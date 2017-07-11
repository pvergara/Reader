package org.ecos.reader.test.unit;

import com.thoughtworks.xstream.XStream;

import org.ecos.reader.core.epub.pojos.container.Container;
import org.ecos.reader.core.epub.pojos.container.RootFile;
import org.ecos.reader.core.epub.pojos.container.RootFiles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SuppressWarnings("SpellCheckingInspection")
public class TestToLearn {
    @BeforeMethod
    public void setUp() throws Exception {
    }

    @Test
    public void hotToAccessToAResourceFile() {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resourceUrl = classLoader.getResource("historia_de_la_vida_del_buscOn_llamado_don_pablos.epub");
        assertThat(resourceUrl, is(not(nullValue())));

        File file = new File(resourceUrl.getPath());

        assertThat(file, is(not(nullValue())));
    }

    @Test
    public void howToAccessToACompressedFile() {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resourceUrl = classLoader.getResource("historia_de_la_vida_del_buscOn_llamado_don_pablos.epub");
        File file = new File(resourceUrl.getPath());

        try(
                // we open the zip file using a java 7 try with resources block so
                // that we don't need a finally.
                ZipInputStream stream = new ZipInputStream(new FileInputStream(file))
        )
        {

            // now iterate through each file in the zip archive. The get
            // next entry call will return a ZipEntry for each file in
            // the stream
            ZipEntry entry;
            while((entry = stream.getNextEntry())!=null)
            {
                // We can read the file information from the ZipEntry.
                String fileInfo = String.format(
                    Locale.getDefault(),
                    "Entry: [%s] len %d added %TD",
                    entry.getName(), entry.getSize(),
                    new Date(entry.getTime())
                    );

                System.out.println(fileInfo);

            }
        } catch (IOException e) {
            System.out.println("CABOOOOOM!!!!!");
            e.printStackTrace();
        }
    }

    @Test
    public void howToEasilyReadATextFilesFromACompressedFile() {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resourceUrl = classLoader.getResource("la_guardia_blanca.epub");
        File file = new File(resourceUrl.getPath());

        try (
                // we open the zip file using a java 7 try with resources block so
                // that we don't need a finally.
                ZipInputStream zipStream = new ZipInputStream(new FileInputStream(file))
        ) {
            ZipEntry entry;
            while ((entry = zipStream.getNextEntry()) != null) {
                if (
                        entry.getName().equals("META-INF/container.xml") ||
                                entry.getName().endsWith("content.opf")
                        ) {
                    Scanner scanner = new Scanner(zipStream);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("CABOOOOOM!!!!!");
            e.printStackTrace();
        }
    }

    @Test
    public void howToEasilyDeserializeAXMLFileThatIsInsideAZip() {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resourceUrl = classLoader.getResource("la_guardia_blanca.epub");
        File file = new File(resourceUrl.getPath());

        try (
                // we open the zip file using a java 7 try with resources block so
                // that we don't need a finally.
                ZipInputStream zipStream = new ZipInputStream(new FileInputStream(file))
        ) {
            ZipEntry entry;
            while ((entry = zipStream.getNextEntry()) != null) {
                if (entry.getName().equals("META-INF/container.xml")) {

                    XStream xstream = new XStream();


                    xstream.alias("container", Container.class);
                    xstream.alias("rootfiles", RootFiles.class);
                    xstream.alias("rootfile", RootFile.class);

                    xstream.processAnnotations(Container.class);
                    xstream.processAnnotations(RootFiles.class);
                    xstream.processAnnotations(RootFile.class);

                    xstream.addImplicitCollection(RootFiles.class, "mRootFiles", RootFile.class);

                    Container container = (Container) xstream.fromXML(zipStream);

                    assertThat(container.getRootFiles(),hasSize(1));
                    RootFile first = container.getRootFiles().first();
                    assertThat(first.getFullPath(),is(equalTo("OEBPS/content.opf")));
                    assertThat(first.getMediaType(),is(equalTo("application/oebps-package+xml")));
                }
            }
        } catch (IOException e) {
            System.out.println("CABOOOOOM!!!!!");
            e.printStackTrace();
        }
    }


}