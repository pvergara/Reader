package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import org.ecos.reader.core.exceptions.DoNoExistsException;

@XStreamAlias("ncx")
public class TableOfContents {

    @XStreamAlias("head")
    private HeadCollection mHeadCollection;

    @XStreamAlias("docTitle")
    private Title mTitle;

    @XStreamAlias("navMap")
    private NavigationMap mNavigationMap;

    public HeadCollection getHeadCollection() {
        return mHeadCollection;
    }

    public Metadata getFirstMetadata() throws DoNoExistsException {
        if(mHeadCollection.size() == 0)
            throw new DoNoExistsException("The collection do not exists or is empty");
        return mHeadCollection.getMetaCollection().get(0);
    }

    public Title getTitle() {
        return mTitle;
    }


    public NavigationMap getNavigationMap() {
        return mNavigationMap;
    }
}