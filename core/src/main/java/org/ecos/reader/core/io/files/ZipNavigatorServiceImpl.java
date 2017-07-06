package org.ecos.reader.core.io.files;

import org.ecos.reader.core.io.files.exceptions.DoNoExistsExcepiton;

@SuppressWarnings("unused")
public class ZipNavigatorServiceImpl implements ZipNavigatorService {
    @Override
    public FileCollection getFilesInside(ZipFile file) throws DoNoExistsExcepiton {

        if(!file.exists())
            throw new DoNoExistsExcepiton("");

        return file.getFiles();
    }

}