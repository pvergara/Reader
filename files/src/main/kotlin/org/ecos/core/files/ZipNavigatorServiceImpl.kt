package org.ecos.core.files

import org.ecos.reader.core.exceptions.DoNoExistsException

import org.ecos.reader.core.exceptions.UnknownError

@Suppress("unused")
class ZipNavigatorServiceImpl : ZipNavigatorService {
    @Throws(DoNoExistsException::class, UnknownError::class)
    override fun getFilesInside(file: ZipFile): FileCollection {
        if (!file.exists())
            throw DoNoExistsException("")

        return file.files
    }
}