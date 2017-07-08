package org.ecos.reader.core.io.files;

import org.ecos.reader.core.io.files.exceptions.DoNoExistsException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import reader.ecos.org.core.io.files.exceptions.UnknownError;

import static java.lang.String.format;

@SuppressWarnings("unused")
public class ZipFileImpl implements ZipFile {
    private File mFileToWorkWith;

    @Override
    public void prepareToUse(File file) {
        mFileToWorkWith = file;
    }

    @Override
    public boolean exists() {
        String filesPathAsString = getFilePathAsString();

        try {
            new FileInputStream(filesPathAsString);
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    private String getFilePathAsString() {
        return mFileToWorkWith.getPath().asString();
    }

    @Override
    public FileCollection getFiles() throws DoNoExistsException, UnknownError {
        String filePathAsString = getFilePathAsString();
        if(!exists())
            throw new DoNoExistsException(format("The file you want to access do not exists in the path you're using (%s)", filePathAsString));

        FileCollection collectionOfInnerFiles = new FileCollectionImpl();

        try(ZipInputStream stream = new ZipInputStream(new FileInputStream(filePathAsString)))
        {
            ZipEntry entry;
            while((entry = stream.getNextEntry())!=null)
            {
                collectionOfInnerFiles.add(FileImpl.from(PathImpl.from(entry.getName())));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnknownError(format("Message: %s",e));
        }
        return collectionOfInnerFiles;
    }
}