package reader.ecos.org.core.io.files;

import java.util.zip.ZipInputStream;

import reader.ecos.org.core.io.files.exceptions.DoNoExistsExcepiton;

@SuppressWarnings("WeakerAccess")
public interface ZipNavigatorService {
    FileCollection getFilesInside(ZipFile file,Path path) throws DoNoExistsExcepiton;
    DirectoryCollection getDirectoriesInside(ZipFile file,Path path);
}
