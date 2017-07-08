package org.ecos.reader.test.unit;

import org.ecos.reader.core.io.files.File;
import org.ecos.reader.core.io.files.FileCollection;
import org.ecos.reader.core.io.files.FileImpl;
import org.ecos.reader.core.io.files.Path;
import org.ecos.reader.core.io.files.PathImpl;
import org.ecos.reader.core.io.files.ZipFile;
import org.ecos.reader.core.io.files.ZipFileImpl;
import org.ecos.reader.core.io.files.exceptions.DoNoExistsException;
import org.testng.annotations.Test;

import java.net.URL;

import reader.ecos.org.core.io.files.exceptions.UnknownError;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;

public class ZipFileTests {

    // -- ----------------------------------------------------------------------------------- --
    // BEWARE OF THIS: UNTIL I FIND A SOLUTION TO TESTS THE SUITE YOU MUST TO "RE-SYNC" THE
    // app's "build.gradle" AT LEAST ONCE. I YOU DON'T MAKE IT AND YOU'RE USING AS>=3 (I'M
    // USING THE BETA AT THIS TIME) THE TESTS RUNNER WILL YOU RETURN A
    // "NOT CLASS FOUND EXCEPTION"
    // -- ----------------------------------------------------------------------------------- --

    @Test
    public void exists(){
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();

        ZipFile epubFile = new ZipFileImpl();
        String resourceName = "historia_de_la_vida_del_buscOn_llamado_don_pablos.epub";
        URL resourceUrl = classLoader.getResource(resourceName);

        Path path = PathImpl.from(resourceUrl.getPath());
        File file = FileImpl.from(path);
        epubFile.prepareToUse(file);

        //Act
        boolean actual = epubFile.exists();

        //Assertions
        assertThat(actual,is(true));
    }

    @Test
    public void doesNotExists(){
        //Arrange
        ZipFile epubFile = new ZipFileImpl();

        Path path = PathImpl.from("INVENTED_FILE_PATH");
        File file = FileImpl.from(path);
        epubFile.prepareToUse(file);

        //Act
        boolean actual = epubFile.exists();

        //Assertions
        assertThat(actual,is(false));
    }

    @Test
    public void gettingTheDifferentFilesInsideTheZip() throws DoNoExistsException, UnknownError {
        //Arrange
        ClassLoader classLoader = getClass().getClassLoader();

        ZipFile epubFile = new ZipFileImpl();
        String resourceName = "historia_de_la_vida_del_buscOn_llamado_don_pablos.epub";
        URL resourceUrl = classLoader.getResource(resourceName);

        Path path = PathImpl.from(resourceUrl.getPath());
        File file = FileImpl.from(path);
        epubFile.prepareToUse(file);

        //Act
        FileCollection collectionOfInnerFiles = epubFile.getFiles();

        //Assertions
        assertThat(collectionOfInnerFiles,hasSize(10));
        assertThat(collectionOfInnerFiles.getPathsAsString(),containsInAnyOrder("mimetype",
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