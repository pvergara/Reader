package org.ecos.epub.binders;


import org.ecos.epub.pojos.content.Content;

public interface ContentBinder {
    Content extractContentFrom(String contentXML);
}