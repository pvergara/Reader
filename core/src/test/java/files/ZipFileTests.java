package files;

import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@SuppressWarnings("SpellCheckingInspection")
public class ZipFileTests {
    @Test
    public void mayIAccessToACertainResourceFile(){
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource("historia_de_la_vida_del_buscOn_llamado_don_pablos.epub");
        assertThat(resource,is(not(nullValue())));

        File file = new File(resource.getPath());

        assertThat(file,is(not(nullValue())));
    }
}