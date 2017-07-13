package org.ecos.reader.core.epub.pojos.content;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XStreamAlias("metadata")
public class Metadata extends AbstractCollection<String> {
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

    @XStreamImplicit(itemFieldName = "dc:subject")
    private List<String> mSubjects;

    public Metadata() {
        mSubjects = new ArrayList<>();
    }

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

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<String> iterator() {
        return mSubjects.iterator();
    }

    @Override
    public boolean add(String subject) {
        return mSubjects.add(subject);
    }

    @Override
    public int size() {
        return mSubjects.size();
    }

    public List<String> getSubjects() {
        return mSubjects;
    }
}
