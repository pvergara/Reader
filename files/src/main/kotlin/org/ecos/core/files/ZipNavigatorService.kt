package org.ecos.core.files

import org.ecos.reader.core.exceptions.DoNoExistsException

import org.ecos.reader.core.exceptions.UnknownError

interface ZipNavigatorService {
    @Throws(DoNoExistsException::class, UnknownError::class)
    fun getFilesInside(file: ZipFile): FileCollection
}