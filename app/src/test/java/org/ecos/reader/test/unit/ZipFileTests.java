package org.ecos.reader.test.unit;

import org.ecos.core.files.File;
import org.ecos.core.files.FileCollection;
import org.ecos.core.files.FileImpl;
import org.ecos.core.files.Path;
import org.ecos.core.files.PathImpl;
import org.ecos.core.files.ZipFile;
import org.ecos.core.files.ZipFileImpl;
import org.ecos.reader.core.exceptions.DoNoExistsException;
import org.ecos.reader.core.exceptions.UnknownError;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

@SuppressWarnings("SpellCheckingInspection")
public class ZipFileTests {
    private ZipFile mAnyZipFile;
    private File mFile;

    // -- ----------------------------------------------------------------------------------- --
    // BEWARE OF THIS: UNTIL I FIND A SOLUTION TO TESTS THE SUITE YOU MUST TO "RE-SYNC" THE
    // app's "build.gradle" AT LEAST ONCE. I YOU DON'T MAKE IT AND YOU'RE USING AS>=3 (I'M
    // USING THE BETA AT THIS TIME) THE TESTS RUNNER WILL YOU RETURN A
    // "NOT CLASS FOUND EXCEPTION"
    // -- ----------------------------------------------------------------------------------- --

    @BeforeMethod
    public void setUp() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        mAnyZipFile = new ZipFileImpl();
        String resourceName = "historia_de_la_vida_del_buscOn_llamado_don_pablos.epub";
        URL resourceUrl = classLoader.getResource(resourceName);
        Path path = PathImpl.Companion.from(resourceUrl.getPath());
        mFile = FileImpl.Companion.from(path);
    }

    @Test
    public void exists(){
        //Arrange
        mAnyZipFile.prepareToUse(mFile);

        //Act
        boolean actual = mAnyZipFile.exists();

        //Assertions
        assertThat(actual,is(true));
    }

    @Test
    public void doesNotExists(){
        //Arrange
        Path path = PathImpl.Companion.from("INVENTED_FILE_PATH");
        File file = FileImpl.Companion.from(path);
        mAnyZipFile.prepareToUse(file);

        //Act
        boolean actual = mAnyZipFile.exists();

        //Assertions
        assertThat(actual,is(false));
    }

    @Test
    public void gettingTheDifferentFilesInsideTheZip() throws DoNoExistsException, UnknownError {
        //Arrange
        mAnyZipFile.prepareToUse(mFile);

        //Act
        FileCollection collectionOfInnerFiles = mAnyZipFile.getFiles();

        //Assertions
        assertThat(collectionOfInnerFiles,hasSize(10));
        assertThat(collectionOfInnerFiles.getPathsAsString(),containsInAnyOrder(
            "mimetype",
            "META-INF/container.xml",
            "OEBPS/pgepub.css",
            "OEBPS/@public@vhost@g@gutenberg@html@files@32315@32315-8-0.txt.html",
            "OEBPS/@public@vhost@g@gutenberg@html@files@32315@32315-8-1.txt.html",
            "OEBPS/@public@vhost@g@gutenberg@html@files@32315@32315-8-2.txt.html",
            "OEBPS/@public@vhost@g@gutenberg@html@files@32315@32315-8-3.txt.html",
            "OEBPS/@public@vhost@g@gutenberg@html@files@32315@32315-8-4.txt.html",
            "OEBPS/toc.ncx",
            "OEBPS/content.opf"));
    }
}