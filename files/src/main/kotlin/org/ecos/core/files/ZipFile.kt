package org.ecos.core.files

interface ZipFile {
    fun prepareToUse(file: File)

    fun exists(): Boolean

    val files: FileCollection
}