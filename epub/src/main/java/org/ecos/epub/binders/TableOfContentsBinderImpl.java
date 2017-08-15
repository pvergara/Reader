package org.ecos.epub.binders;

import com.thoughtworks.xstream.XStream;

import org.ecos.epub.pojos.content.Content;
import org.ecos.epub.pojos.toc.HeadCollection;
import org.ecos.epub.pojos.toc.Metadata;
import org.ecos.epub.pojos.toc.NavigationLabel;
import org.ecos.epub.pojos.toc.NavigationMap;
import org.ecos.epub.pojos.toc.NavigationPoint;
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

        xstream.alias("navMap", NavigationMap.class);
        xstream.alias("navPoint", NavigationPoint.class);
        xstream.alias("navLabel", NavigationLabel.class);
        xstream.alias("content", Content.class);

        xstream.processAnnotations(TableOfContents.class);
        xstream.processAnnotations(HeadCollection.class);
        xstream.processAnnotations(Metadata.class);

        xstream.processAnnotations(NavigationMap.class);
        xstream.processAnnotations(NavigationPoint.class);
        xstream.processAnnotations(NavigationLabel.class);
        xstream.processAnnotations(Content.class);

        xstream.addImplicitCollection(HeadCollection.class, "mMetaCollection", Metadata.class);
        xstream.addImplicitCollection(NavigationMap.class, "mNavigationPoints", NavigationPoint.class);

        xstream.addImplicitCollection(NavigationPoint.class, "mInnerNavigationPoints", NavigationPoint.class);

        xstream.ignoreUnknownElements();

        return (TableOfContents) xstream.fromXML(tableOfContentsAsXML);

    }
}
