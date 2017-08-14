package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import org.ecos.core.interfaces.AsString;

public class NavigationLabel implements AsString {
    @XStreamAlias("text")
    private String mText;

    @XStreamAlias("xml:lang")
    @XStreamAsAttribute
    private String mLanguage;
    @XStreamAlias("dir")
    @XStreamAsAttribute
    private String mDirection;

    @Override
    public String asString() {
        return mText;
    }
}
