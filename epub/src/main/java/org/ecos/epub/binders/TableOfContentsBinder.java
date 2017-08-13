package org.ecos.epub.binders;

import org.ecos.epub.pojos.toc.TableOfContents;

public interface TableOfContentsBinder {
    TableOfContents extractFrom(String tableOfContentsAsXML);
}
