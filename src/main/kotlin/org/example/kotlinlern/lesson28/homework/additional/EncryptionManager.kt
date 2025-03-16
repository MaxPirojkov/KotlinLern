package org.example.kotlinlern.lesson28.homework.additional

import java.io.File

class EncryptionManager(val fileProcessor: FileProcessor, val encryptor: Encryptor) {
    fun encryptFilesInDirectory(directory: File, backupDir: File, extension: String) {
        val files = if (directory.exists()) {
            fileProcessor.findFilesByExtension(extension, directory)
        } else {
            println("проверьте путь $directory")
            emptyList()
        }

        fileProcessor.encryptFiles(files, encryptor)

        fileProcessor.moveToBackup(files, backupDir, directory)
    }
}