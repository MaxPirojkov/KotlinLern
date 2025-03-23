package org.example.kotlinlern.lesson28.homework

import org.example.kotlinlern.lesson10.mutableList
import java.io.File

fun main() {
    val myMap = mapOf("one" to 1, "two" to 2, "three" to 3)
//    createFileTask1("workspace/task1/example.txt")
//
//    createDirectoryTask2("workspace/task2/testDir")
//
//    twoDirectoryTask3("workspace/task3/structure")
//    createAndDeleteTask4("workspace/task4/temp")
//    writeReadFile("workspace/task5/config/config.txt", myMap)
//
    printAllTask6("workspace")
    //readmeTask7("workspace/task9/docs")

    // Task 8
//    createFileTask1("workspace/task10/data/1/4/prod/data14.mysql")
//    createFileTask1("workspace/task10/data/2/3/prod/data23.mysql")
//    createFileTask1("workspace/task10/data/5/2/prod/data52.mysql")
//    createDirectoryTask2("workspace/task10/backup")
//    backupTask8("workspace/task10/backup")

}

/*
Задача 1
Создайте текстовый файл workspace/task1/example.txt
запишите в него строку "Hello, Kotlin!", а затем проверьте, существует ли файл.
*/
fun createFileTask1(path: String) {
    File(path).apply {
        if (this.exists()) {
            println("файл существует")
        } else {
            parentFile.mkdirs()
            createNewFile()
            writeText("Hello, Kotlin!")
            println("файл создан")
        }
    }
}

/*
Задача 2
Создайте директорию workspace/task2/testDir
проверьте, является ли она директорией, и выведите её абсолютный путь.
 */

fun createDirectoryTask2(path: String) {
    File(path).apply {
        if (this.isDirectory) {
            println("Директория существует")
        } else {
            mkdirs()
            println(path)
            println("директория создана")
        }
    }
}

/*
Задача 3
Создайте директорию workspace/task3/structure.
Внутри директории structure создайте папку myDir
с двумя вложенными поддиректориями subDir1
и subDir2.
Проверьте, что myDir действительно содержит эти поддиректории.
 */

fun twoDirectoryTask3(path: String) {
    val subDir1 = "$path/myDir/subDir1"
    val subDir2 = "$path/myDir/subDir2"
    val myDir = File("$path/myDir")

    createDirectoryTask2(subDir1)
    createDirectoryTask2(subDir2)

    val subDirs = myDir.listFiles().filter { it.isDirectory }.map { it.name }
    if ("subDir1" in subDirs && "subDir2" in subDirs) {
        println("myDir содержит subDir1 и subDir2")
    }


}

/*
Задача 4
Создайте директорию workspace/task4/temp.
Внутри директории temp создайте несколько вложенных файлов
и директорий. Удалите директорию workspace/task4 со всем содержимым
 */

fun createAndDeleteTask4(path: String) {
    val basicPath = File(path)
    val file1 = "$path/exampleOne.txt"
    val file2 = "$path/exampleTwo.txt"
    val deletePath = File("workspace/task4")

    createDirectoryTask2(path)
    twoDirectoryTask3(path)
    createFileTask1(file1)
    createFileTask1(file2)

    if (deletePath.deleteRecursively()) {
        println("Файл удален")
    } else {
        println("Не удалось удалить файл")
    }
}

/*
Задача 5
Создайте файл workspace/task5/config/config.txt
запишите в него список параметров (в формате ключ=значение),
а затем прочитайте файл и выведите только значения.
 */

fun writeReadFile(path: String, myMap: Map<String, Int>) {

    val file = File(path).apply {
        parentFile.mkdirs()
        createNewFile()
        writeText(myMap.map { "${it.key}=${it.value}" }.joinToString("\n"))
    }
    if (file.exists()) {
        file.readLines().map {
            println(it.split("=")[1])
        }
    } else {
        println("Файл не найден")
    }
}

/*
Задача 6
Пройди по всем вложенным директориям workspace
и выведи в консоль сначала пути директорий, а потом пути файлов
 */
fun printAllTask6(path: String) {
    val dir = File(path)


    var result = dir.walk().groupBy {
        if (it.isDirectory) "Directory" else "File"
    }
    println(result)
}

/*
Задача 7
Создайте директорию workspace/task9/docs.
Проверь, есть ли файл с именем readme.md.
Если файла нет,
создайте его
и запишите текст "This is a README file."
 */

fun readmeTask7(path: String) {
    val fileName = "readme.md"
    val fullPath = File(path, fileName)

    if (fullPath.exists()) {
        println("файл существует")
    } else {
        fullPath.apply {
            parentFile.mkdirs()
            createNewFile()
            writeText("This is a README file.")
            println("файл создан")
        }
    }
}

/*
Задача 8
Создайте файлы
workspace/task10/data/1/4/prod/data14.mysql
workspace/task10/data/2/3/prod/data23.mysql
workspace/task10/data/5/2/prod/data52.mysql
Создайте директорию workspace/task10/backup
и скопируйте туда файлы из workspace/task10/data
сохраняя структуру директорий.
Для копирования используй метод copyTo
 */

fun backupTask8(path: String) {
    val backUpDir = File(path)
    val baseDir = File("workspace/task10/data/")

    if (backUpDir.exists()) {
        baseDir.walk().filter { it.isFile }.forEach {
            val backupFile = File(backUpDir, it.relativeTo(baseDir).path)
            backupFile.parentFile.mkdirs()
            if (backupFile.exists()) {
                println("${backupFile} файл уже существует")
            } else {
                it.copyTo(backupFile, false)
                println("${it.name} файл бэкап создан")
            }
        }
    } else {
        println("$backUpDir не существует")
        backUpDir.mkdirs()
        println("$backUpDir директория создана")
    }

}