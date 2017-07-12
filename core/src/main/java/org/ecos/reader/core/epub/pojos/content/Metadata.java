package org.ecos.reader.core.epub.pojos.content;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("metadata")
public class Metadata {
    @XStreamAlias("dc:rights")
    private String mRights;
    @XStreamAlias("dc:identifier")
    private String mIdentifier;
    @XStreamAlias("dc:creator")
    private String mCreator;
    @XStreamAlias("dc:contributor")
    private String mContributor;
    @XStreamAlias("dc:title")
    private String mTitle;
    @XStreamAlias("dc:language")
    private String mLanguage;

    public String getRights() {
        return mRights;
    }

    public String getIdentifier() {
        return mIdentifier;
    }

    public String getCreator() {
        return mCreator;
    }

    public String getContributor() {
        return mContributor;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getLanguage() {
        return mLanguage;
    }
}
