package org.ecos.core.test.unit;

import org.ecos.reader.core.epub.binders.ContainerBinder;
import org.ecos.reader.core.epub.binders.ContainerBinderImpl;
import org.ecos.reader.core.epub.pojos.container.Container;
import org.ecos.reader.core.epub.pojos.container.RootFile;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class ContainerBinderTests {

    @Test
    public void givingACorrectContainerXMLThenTheResultMustBeCorrect() {
        ContainerBinder binder = new ContainerBinderImpl();

        String containerXML = "" +
                "<?xml version='1.0' encoding='utf-8'?>\n" +
                "<container xmlns=\"urn:oasis:names:tc:opendocument:xmlns:container\" version=\"1.0\">\n" +
                "  <rootfiles>\n" +
                "    <rootfile media-type=\"application/oebps-package+xml\" full-path=\"OEBPS/content.opf\"/>\n" +
                "  </rootfiles>\n" +
                "</container>";


        Container container = binder.extractContainerFrom(containerXML);

        assertThat(container.getRootFiles(), Matchers.hasSize(1));
        RootFile first = container.getRootFiles().first();
        assertThat(first.getFullPath(), is(equalTo("OEBPS/content.opf")));
        assertThat(first.getMediaType(), is(equalTo("application/oebps-package+xml")));
    }

    @Test
    public void givingAnSubtleIncorrectContainerXMLThenTheResultMustBeIncorrect() throws Exception {
        throw new Exception("TODO");
    }
}