package org.ecos.core.files

import java.util.*

class FileCollectionImpl internal constructor() : AbstractCollection<File>(), FileCollection {
    private val mCollectionOfFiles: MutableCollection<File>

    override val pathsAsString: Collection<String>

    get() = mCollectionOfFiles.map { it.path.asString() }

    init {
        mCollectionOfFiles = ArrayList<File>()
    }

    override fun add(element: File): Boolean {
        return mCollectionOfFiles.add(element)
    }

    override val size: Int
        get() = mCollectionOfFiles.size

    override fun iterator(): MutableIterator<File> {
        return mCollectionOfFiles.iterator()
    }
}