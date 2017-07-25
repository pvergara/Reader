package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import org.w3c.types.Identifier;

import javax.xml.bind.annotation.XmlAttribute;

class Content {
    @XmlAttribute
    @XStreamAlias("src")
    private String playOrder;

    @XmlAttribute
    @XStreamAlias("id")
    private Identifier mId;

}
