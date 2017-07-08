package org.ecos.reader.core.io.files;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FileCollectionImpl
    extends AbstractCollection<File>
    implements FileCollection
{
    private Collection<File> mCollectionOfFiles;

    FileCollectionImpl() {
        mCollectionOfFiles = new ArrayList<>();
    }

    @Override
    public boolean add(File file) {
        return mCollectionOfFiles.add(file);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<File> iterator() {
        return mCollectionOfFiles.iterator();
    }

    @Override
    public int size() {
        return mCollectionOfFiles.size();
    }

    @Override
    public Collection<String> getPathsAsString() {
        Collection<String> result = new ArrayList<>();
        for (File item : mCollectionOfFiles) {
            result.add(item.getPath().asString());
        }
        return result;
    }
}