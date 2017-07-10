package org.ecos.reader.core.epub.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("container")
public class Container {
    @XStreamAlias("rootfiles")
    private RootFiles mRootFiles;

    public RootFiles getRootFiles() {
        return mRootFiles;
    }
}
