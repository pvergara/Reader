package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import org.w3c.types.Identifier;

import javax.xml.bind.annotation.XmlAttribute;

@XStreamAlias("navPoint")
public class NavigationPoint {
    @XStreamAlias("navLabel")
    private NavigationLabel mNavigationLabel;

    @XStreamAlias("content")
    private Content mContent;

    @XmlAttribute
    @XStreamAlias("id")
    private Identifier mId;
    @XmlAttribute
    @XStreamAlias("playOrder")
    private String playOrder;

    @XmlAttribute
    @XStreamAlias("class")
    private String mClass;

}
