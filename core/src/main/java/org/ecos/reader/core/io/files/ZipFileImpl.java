package org.ecos.reader.core.io.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

@SuppressWarnings("unused")
public class ZipFileImpl implements ZipFile {
    private File mFileToWorkWith;

    @Override
    public void prepareToUse(File file) {
        mFileToWorkWith = file;
    }

    @Override
    public boolean exists() {
        InputStream stream = null;
        String filesPathAsString = mFileToWorkWith.getPath().asString();
        try {
            FileInputStream inputStream = new FileInputStream(filesPathAsString);
            stream = new ZipInputStream(inputStream);
        } catch (FileNotFoundException e) {
            return false;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public FileCollection getFiles() {
        return null;
    }
}