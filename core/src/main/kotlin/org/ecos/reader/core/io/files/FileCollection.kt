package org.ecos.reader.core.io.files

interface FileCollection : Collection<File> {
    val pathsAsString: Collection<String>
}