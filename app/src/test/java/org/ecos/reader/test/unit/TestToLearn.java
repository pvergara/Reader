package org.ecos.reader.test.unit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SuppressWarnings("SpellCheckingInspection")
public class TestToLearn {

    private byte[] buffer;

    @BeforeMethod
    public void setUp() throws Exception {
        buffer = new byte[2048];
    }

    @Test
    public void hotToAccessToAResourceFile(){
        ClassLoader classLoader = getClass().getClassLoader();

        URL resourceUrl = classLoader.getResource("historia_de_la_vida_del_buscOn_llamado_don_pablos.epub");
        assertThat(resourceUrl,is(not(nullValue())));

        File file = new File(resourceUrl.getPath());

        assertThat(file,is(not(nullValue())));
    }

    @Test
    public void howToAccessToACompressedFile(){
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
}