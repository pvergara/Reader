package org.ecos.reader.core.io.files;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings({"unused", "WeakerAccess"})
public class FileCollectionImpl
    extends AbstractCollection<File>
    implements FileCollection
{
    private Collection<File> mCollectionOfFiles;

    public FileCollectionImpl() {
        mCollectionOfFiles = new ArrayList<>();
    }

    @Override
    public boolean add(File file) {
        return mCollectionOfFiles.add(file);
    }

    @Override
    @NotNull
    public Iterator<File> iterator() {
        return mCollectionOfFiles.iterator();
    }

    @Override
    public int size() {
        return mCollectionOfFiles.size();
    }
}