package org.ecos.reader.core.io.files;

import org.ecos.reader.core.io.files.exceptions.DoNoExistsException;

import reader.ecos.org.core.io.files.exceptions.UnknownError;

@SuppressWarnings("unused")
public class ZipNavigatorServiceImpl implements ZipNavigatorService {
    @Override
    public FileCollection getFilesInside(ZipFile file) throws DoNoExistsException, UnknownError {

        if(!file.exists())
            throw new DoNoExistsException("");

        return file.getFiles();
    }

}