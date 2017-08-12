package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("meta")
public class Metadata {
    @XStreamAsAttribute
    @XStreamAlias("content")
    private String mContent;
    @XStreamAsAttribute
    @XStreamAlias("name")
    private String mName;

    private Metadata(String content, String name) {
        mContent = content;
        mName = name;
    }

    public static Metadata from(String content, String name) {
        return new Metadata(content,name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metadata metadata = (Metadata) o;

        return
            (mContent != null ? mContent.equals(metadata.mContent) : metadata.mContent == null) &&
            (mName != null ? mName.equals(metadata.mName) : metadata.mName == null);
    }

    @Override
    public int hashCode() {
        int result = mContent != null ? mContent.hashCode() : 0;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        return result;
    }
}
