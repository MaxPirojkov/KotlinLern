package org.example.kotlinlern.lesson28.homework.additional

import java.io.File

fun main() {
    val baseDir = File("additionalHomework/data")
    val backupDir = File("additionalHomework/backup")

    baseDir.deleteRecursively()
    backupDir.deleteRecursively()

    baseDir.mkdirs()
    val testF = File(baseDir, "test.txt")
    testF.writeText("Hello")

    val encryptor = EncryptorImpl(3)
    val fileProcessor = FileProcessorImpl()

    val encryptionManager = EncryptionManager(fileProcessor, encryptor)


    encryptionManager.encryptFilesInDirectory(baseDir, backupDir, "txt")

    println("data: ${baseDir}")
    println("backup: ${backupDir.list().joinToString()}")
    println("Содержимое test_encr.txt: ${File(baseDir, "test_encr.txt").readText()}")
    println("Содержимое backup/test.txt: ${File(backupDir, "test.txt").readText()}")
}
