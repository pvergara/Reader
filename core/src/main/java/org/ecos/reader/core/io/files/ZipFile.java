package org.ecos.reader.core.io.files;


@SuppressWarnings("unused")
public interface ZipFile {
    void prepareToUse(File file);
    boolean exists();

    FileCollection getFiles();
}
