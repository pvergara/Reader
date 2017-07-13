package org.ecos.core.files

class PathImpl private constructor(private val pathAsString: String) : Path {

    override fun asString(): String {
        return pathAsString
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val path = other as PathImpl?

        return pathAsString == path!!.pathAsString
    }

    override fun hashCode(): Int {
        return pathAsString.hashCode()
    }

    companion object {
        fun from(pathAsString: String): Path {
            return PathImpl(pathAsString)
        }
    }
}
