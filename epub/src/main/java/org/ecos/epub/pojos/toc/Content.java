package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Content {
    @XStreamAsAttribute
    @XStreamAlias("id")
//    private Identifier mId; /*Waiting for https://trello.com/c/0FqTQe5f/12-xml-xyz-type-to-custom-type*/
    private String mId;

    @XStreamAsAttribute
    @XStreamAlias("src")
    private String mSourceReference;

    public String getSourceReference() {
        return mSourceReference;
    }
}
