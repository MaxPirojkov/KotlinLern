package org.example.kotlinlern.lesson28

import java.io.File

// Работа с файлами

fun main() {

    val file = File("path/to/your/file.txt")
    val directory = File("path/to/your/")

    file.parentFile.mkdirs()     //parentFile - вернет адрес родителя - path/to/your/        mkdirs() - создаст в путь до уазанного файла директори

    val isNewFileCreated: Boolean = file.createNewFile()
    if (isNewFileCreated) {
        println("файл был создан")
    } else {
        println("файл уже существует")
    }


    if (file.exists()) {
        println("файл существует")
    } else {
        println("файл не создан")
    }

    file.writeText("Hello world ")        //передали текст в файл

    val text = file.readText()
    println(text)

    (1..5).forEach {
        file.parentFile.resolve("$it").mkdirs()
    }

    val files = directory.listFiles()      // listFiles() - позволяет получить все что у нас есть
    files?.forEach { file ->
        if (file.isFile) {
            println(file.name)  // file.name - выводит имя последней директории / файла
        }
    }

    if (file.parentFile.delete()) {
        println("Файл удален")
    } else {
        println("Не удалось удалить файл")
    }

    if (file.parentFile.deleteRecursively()) {
        println("Директория и все ее содержимое удалено")
    } else {
        println("Не удалось удалить директорию")
    }

    file.walk()
        .filter { it.isFile }            // walk проходит по пути по всем вложенным папкам и файлам представляет в виде спискак
        .associateWith { it.readLines() }       // данные превращается в словарь, ключ это файл - значение это содиржимое
        .filterValues { data ->                   // если есть файл с text то добавит в словарь
            data.any { it.contains("text") }
        }

    println(file.absoluteFile) // выводит весь (абсолютный) путь до файла /Users/pppp/Documents/GitHub/KotlinLern/path/to/your/file.txt

    val t: String = file.parent
    val k: File = file.parentFile

    println(t)
    println(k)

    val baseDir = File("path/to")
    val file1 = File("path/to/nested/file.txt")
    val ralative = file1.toRelativeString(baseDir)
    println(file1.toRelativeString(baseDir))
    val baseDir2 = File("path2/to")
    val file3 = baseDir2.resolve(ralative)
    file3.parentFile.mkdirs()
    file3.createNewFile()

}