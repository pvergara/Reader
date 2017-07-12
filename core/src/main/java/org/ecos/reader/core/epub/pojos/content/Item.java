package org.ecos.reader.core.epub.pojos.content;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@SuppressWarnings("unused")
@XStreamAlias("item")
public class Item {
    @XStreamAlias("id")
    @XStreamAsAttribute
    private String mId;

    @XStreamAlias("media-type")
    @XStreamAsAttribute
    private String mMediaType;

    @XStreamAlias("href")
    @XStreamAsAttribute
    private String mHypermediaReference;

    public String getId() {
        return mId;
    }

    public String getMediaType() {
        return mMediaType;
    }

    public String getHypermediaReference() {
        return mHypermediaReference;
    }
}