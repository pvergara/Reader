package org.ecos.reader.core.io.files

import org.ecos.reader.core.io.files.exceptions.DoNoExistsException

import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

import org.ecos.reader.core.io.files.exceptions.UnknownError

import java.lang.String.format
import org.ecos.reader.core.io.files.FileImpl.Companion

class ZipFileImpl : ZipFile {
    private var mFileToWorkWith: File? = null

    override fun prepareToUse(file: File) {
        mFileToWorkWith = file
    }

    override fun exists(): Boolean {
        val filesPathAsString = filePathAsString

        try {
            FileInputStream(filesPathAsString)
        } catch (e: FileNotFoundException) {
            return false
        }

        return true
    }

    private val filePathAsString: String
        get() = mFileToWorkWith!!.path.asString()

    override val files: FileCollection
        @Throws(DoNoExistsException::class, UnknownError::class)
        get() {
            val filePathAsString = filePathAsString
            if (!exists())
                throw DoNoExistsException(format("The file you want to access do not exists in the path you're using (%s)", filePathAsString))

            val collectionOfInnerFiles = FileCollectionImpl()

            try {
                ZipInputStream(FileInputStream(filePathAsString)).use { stream ->
                    while (true){
                        val entry = stream.nextEntry ?: break
                        collectionOfInnerFiles.add(FileImpl.from(PathImpl.from(entry.name)))
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
                throw UnknownError(format("Message: %s", e))
            }

            return collectionOfInnerFiles
        }
}