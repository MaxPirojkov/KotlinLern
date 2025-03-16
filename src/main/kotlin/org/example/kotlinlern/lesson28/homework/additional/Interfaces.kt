package org.example.kotlinlern.lesson28.homework.additional

import java.io.File

interface FileProcessor {
    fun findFilesByExtension(extension: String, directory: File): List<File>

    fun encryptFiles(files: List<File>, encryptor: Encryptor)
    fun moveToBackup(files: List<File>, backupDir: File, base: File)
}

interface Encryptor {
   fun encrypt(content: String): String

}