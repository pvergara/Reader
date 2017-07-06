package org.ecos.reader.test.unit;

import org.ecos.reader.core.io.files.File;
import org.ecos.reader.core.io.files.FileImpl;
import org.ecos.reader.core.io.files.Path;
import org.ecos.reader.core.io.files.PathImpl;
import org.ecos.reader.core.io.files.ZipFile;
import org.ecos.reader.core.io.files.ZipFileImpl;
import org.testng.annotations.Test;

import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ZipFileTests {
    @Test
    public void exists(){
        ClassLoader classLoader = getClass().getClassLoader();

        ZipFile epubFile = new ZipFileImpl();
        URL resourceUrl = classLoader.getResource("historia_de_la_vida_del_buscOn_llamado_don_pablos.epub");

        Path path = PathImpl.from(resourceUrl.getPath());
        File file = FileImpl.from(path);
        epubFile.prepareToUse(file);

        assertThat(epubFile.exists(),is(true));
    }
}
