package org.ecos.reader.core.epub.binders;

import org.ecos.reader.core.epub.pojos.container.Container;

public interface ContainerBinder {
    Container extractContainerFrom(String containerXML);
}