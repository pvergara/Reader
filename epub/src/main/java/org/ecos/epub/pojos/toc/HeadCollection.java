package org.ecos.epub.pojos.toc;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HeadCollection extends AbstractCollection<Metadata> {
    public HeadCollection() {
        mMetaCollection = new ArrayList<>();
    }

    @XStreamImplicit
    private List<Metadata> mMetaCollection;

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<Metadata> iterator() {
        return mMetaCollection.iterator();
    }

    @Override
    public int size() {
        return mMetaCollection.size();
    }

    @Override
    public boolean add(Metadata metadata) {
        return mMetaCollection.add(metadata);
    }

    List<Metadata> getMetaCollection() {
        return mMetaCollection;
    }
}
