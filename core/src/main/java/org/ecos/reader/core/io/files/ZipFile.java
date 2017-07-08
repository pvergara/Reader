package org.ecos.reader.core.io.files;

import org.ecos.reader.core.io.files.exceptions.DoNoExistsException;

import reader.ecos.org.core.io.files.exceptions.UnknownError;

public interface ZipFile {
    void prepareToUse(File file);

    boolean exists();

    FileCollection getFiles() throws DoNoExistsException, UnknownError;
}