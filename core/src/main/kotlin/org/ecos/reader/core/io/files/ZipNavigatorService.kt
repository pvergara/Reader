package org.ecos.reader.core.io.files

import org.ecos.reader.core.io.files.exceptions.DoNoExistsException

import org.ecos.reader.core.io.files.exceptions.UnknownError

interface ZipNavigatorService {
    @Throws(DoNoExistsException::class, UnknownError::class)
    fun getFilesInside(file: ZipFile): FileCollection
}