package org.ecos.epub.binders.toc;

import com.thoughtworks.xstream.XStream;

import org.ecos.epub.pojos.toc.HeadCollection;
import org.ecos.epub.pojos.toc.Metadata;
import org.ecos.epub.pojos.toc.TableOfContents;
import org.ecos.epub.pojos.toc.Title;

public class TableOfContentsBinderImpl implements TableOfContentsBinder {
    @Override
    public TableOfContents extractFrom(String tableOfContentsAsXML) {
        XStream xstream = new XStream();

        xstream.alias("ncx", TableOfContents.class);
        xstream.alias("head", HeadCollection.class);
        xstream.alias("meta", Metadata.class);

        xstream.alias("docTitle", Title.class);

        xstream.processAnnotations(TableOfContents.class);
        xstream.processAnnotations(HeadCollection.class);
        xstream.processAnnotations(Metadata.class);

        xstream.addImplicitCollection(HeadCollection.class, "mMetaCollection", Metadata.class);

        xstream.ignoreUnknownElements();

        return (TableOfContents) xstream.fromXML(tableOfContentsAsXML);

    }
}
