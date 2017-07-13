package org.ecos.epub.binders;

import com.thoughtworks.xstream.XStream;

import org.ecos.epub.pojos.container.Container;
import org.ecos.epub.pojos.container.RootFile;
import org.ecos.epub.pojos.container.RootFiles;


public class ContainerBinderImpl implements ContainerBinder {
    @Override
    public Container extractContainerFrom(String containerXML) {
        XStream xstream = new XStream();

        xstream.alias("container", Container.class);
        xstream.alias("rootfiles", RootFiles.class);
        xstream.alias("rootfile", RootFile.class);

        xstream.processAnnotations(Container.class);
        xstream.processAnnotations(RootFiles.class);
        xstream.processAnnotations(RootFile.class);

        xstream.addImplicitCollection(RootFiles.class, "mRootFiles", RootFile.class);
        return (Container) xstream.fromXML(containerXML);
    }
}