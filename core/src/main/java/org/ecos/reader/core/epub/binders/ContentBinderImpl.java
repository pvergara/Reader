package org.ecos.reader.core.epub.binders;

import com.thoughtworks.xstream.XStream;

import org.ecos.reader.core.epub.pojos.content.Content;
import org.ecos.reader.core.epub.pojos.content.Item;
import org.ecos.reader.core.epub.pojos.content.Manifest;
import org.ecos.reader.core.epub.pojos.content.Metadata;

public class ContentBinderImpl implements ContentBinder {
    @Override
    public Content extractContentFrom(String contentXML) {
        XStream xstream = new XStream();


        xstream.alias("package", Content.class);
        xstream.processAnnotations(Content.class);

        xstream.alias("metadata", Metadata.class);
        xstream.processAnnotations(Metadata.class);

        xstream.alias("manifest", Manifest.class);
        xstream.processAnnotations(Manifest.class);

        xstream.alias("item", Item.class);
        xstream.processAnnotations(Item.class);

        xstream.addImplicitCollection(Manifest.class,"mManifestItems",Item.class);

        xstream.ignoreUnknownElements();

        return (Content) xstream.fromXML(contentXML);

    }
}