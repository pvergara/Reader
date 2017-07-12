package org.ecos.reader.core.epub.binders;


import org.ecos.reader.core.epub.pojos.content.Content;

public interface ContentBinder {
    Content extractContentFrom(String contentXML);
}