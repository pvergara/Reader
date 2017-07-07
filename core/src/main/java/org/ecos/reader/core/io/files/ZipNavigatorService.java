package org.ecos.reader.core.io.files;

import org.ecos.reader.core.io.files.exceptions.DoNoExistsException;

import reader.ecos.org.core.io.files.exceptions.UnknownError;

@SuppressWarnings("unused")
public interface ZipNavigatorService {
    FileCollection getFilesInside(ZipFile file) throws DoNoExistsException, UnknownError;
}