package org.ecos.core.files

interface FileCollection : Collection<File> {
    val pathsAsString: Collection<String>
}