package org.ecos.reader.core.io.files

import org.ecos.reader.core.io.files.exceptions.DoNoExistsException

import org.ecos.reader.core.io.files.exceptions.UnknownError

@Suppress("unused")
class ZipNavigatorServiceImpl : ZipNavigatorService {
    @Throws(DoNoExistsException::class, UnknownError::class)
    override fun getFilesInside(file: ZipFile): FileCollection {
        if (!file.exists())
            throw DoNoExistsException("")

        return file.files
    }
}