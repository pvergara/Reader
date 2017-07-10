package org.ecos.reader.core.epub.pojos;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RootFiles extends AbstractCollection<RootFile> {
    @XStreamImplicit
    private List<RootFile> mRootFiles;

    public RootFiles() {
        mRootFiles = new ArrayList<>();
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<RootFile> iterator() {
        return mRootFiles.iterator();
    }

    @Override
    public boolean add(RootFile rootFile) {
        return mRootFiles.add(rootFile);
    }

    @Override
    public int size() {
        return mRootFiles.size();
    }

    public RootFile first() {
        return mRootFiles.get(0);
    }
}