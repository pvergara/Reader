package org.ecos.reader.core.io.files;

import org.ecos.reader.core.io.files.exceptions.DoNoExistsExcepiton;

@SuppressWarnings("unused")
public interface ZipNavigatorService {
    FileCollection getFilesInside(ZipFile file,Path path) throws DoNoExistsExcepiton;
    DirectoryCollection getDirectoriesInside(ZipFile file,Path path);
}