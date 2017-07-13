package org.ecos.epub.binders;

import org.ecos.epub.pojos.container.Container;

public interface ContainerBinder {
    Container extractContainerFrom(String containerXML);
}