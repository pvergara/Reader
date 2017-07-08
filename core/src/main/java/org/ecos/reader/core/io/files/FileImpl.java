package org.ecos.reader.core.io.files;

public class FileImpl implements File {
    private Path mPath;

    private FileImpl(Path path) {
        mPath = path;
    }

    public static File from(Path path){
        return new FileImpl(path);
    }

    @Override
    public Path getPath() {
        return mPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileImpl file = (FileImpl) o;

        return mPath.equals(file.mPath);
    }

    @Override
    public int hashCode() {
        return mPath.hashCode();
    }
}