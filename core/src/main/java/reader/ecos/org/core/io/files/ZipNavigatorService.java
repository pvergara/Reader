package reader.ecos.org.core.io.files;

import reader.ecos.org.core.io.files.exceptions.DoNoExistsExcepiton;

@SuppressWarnings("unused")
public interface ZipNavigatorService {
    FileCollection getFilesInside(ZipFile file,Path path) throws DoNoExistsExcepiton;
    DirectoryCollection getDirectoriesInside(ZipFile file,Path path);
}