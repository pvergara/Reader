package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

class NavigationLabel {
    @XStreamAlias("Text")
    private String mText;

    @XStreamAlias("xml:lang")
    @XStreamAsAttribute
    private String mLanguage;
    @XStreamAlias("dir")
    @XStreamAsAttribute
    private String mDirection;

}
