package org.ecos.epub.pojos.container;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("rootfile")
public class RootFile {
    @XStreamAlias("media-type")
    @XStreamAsAttribute
    private String mMediaType;
    @XStreamAlias("full-path")
    @XStreamAsAttribute
    private String mFullPath;

    public String getMediaType() {
        return mMediaType;
    }

    public String getFullPath() {
        return mFullPath;
    }
}
