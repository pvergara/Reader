package org.ecos.reader.core.epub.pojos.content;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XStreamAlias("manifest")
public class Manifest extends AbstractCollection<Item>
{
    @XStreamImplicit
    private List<Item> mManifestItems;

    public Manifest() {
        mManifestItems = new ArrayList<>();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<Item> iterator() {
        return mManifestItems.iterator();
    }

    @Override
    public boolean add(Item item) {
        return mManifestItems.add(item);
    }

    @Override
    public int size() {
        return mManifestItems.size();
    }
}
