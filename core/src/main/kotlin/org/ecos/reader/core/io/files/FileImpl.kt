package org.ecos.reader.core.io.files

class FileImpl private constructor(private val mPath: Path) : File {
    override val path: Path
        get() = mPath

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val file = other as FileImpl?

        return mPath == file!!.mPath
    }

    override fun hashCode(): Int {
        return mPath.hashCode()
    }

    companion object {

        fun from(path: Path): File {
            return FileImpl(path)
        }
    }
}