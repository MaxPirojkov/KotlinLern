package org.example.kotlinlern.lesson28.homework.additional

import java.io.File

class FileProcessorImpl() : FileProcessor {

    override fun findFilesByExtension(extension: String, directory: File): List<File> {

        return if (directory.isDirectory && directory.exists()) {
            directory.walk()
                .filter { it.isFile && it.extension == extension }
                .toList()
        } else {
            emptyList()
        }
    }

    override fun encryptFiles(files: List<File>, encryptor: Encryptor) {
        files.filter { it.exists() }.forEach {
            it.writeText(encryptor.encrypt(it.readText()))
        }
    }

    override fun moveToBackup(files: List<File>, backupDir: File, base: File) {
        backupDir.mkdirs()
        files.filter { it.isFile }.forEach {
            val backupFile = File(backupDir, it.relativeTo(base).path)
            backupFile.parentFile.mkdirs()
            it.renameTo(backupFile)
        }
    }

}