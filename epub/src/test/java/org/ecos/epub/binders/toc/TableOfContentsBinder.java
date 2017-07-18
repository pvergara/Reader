package org.ecos.epub.binders.toc;

import org.ecos.epub.pojos.toc.TableOfContents;

public interface TableOfContentsBinder {
    TableOfContents extractFrom(String tableOfContentsAsXML);
}
