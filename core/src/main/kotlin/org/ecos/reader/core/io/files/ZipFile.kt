package org.ecos.reader.core.io.files

interface ZipFile {
    fun prepareToUse(file: File)

    fun exists(): Boolean

    val files: FileCollection
}