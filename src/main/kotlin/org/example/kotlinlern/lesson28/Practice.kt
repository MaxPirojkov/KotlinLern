package org.example.kotlinlern.lesson28

import java.io.File

fun main() {
    val myMap = mapOf("one" to 1.1, "two" to 2.2, "three" to 3.3)
    //writeDataToFile(myMap, "path/practice.file.txt")

  //  println( readTextAndTransform("path/practice.file.txt"))
    createFileOrDirectory("workspace/task1/example.txt")
}

fun createFileOrDirectory(path: String) {
    File(path).apply {
        if (path.endsWith("/")) {
            mkdirs()       // тут знаем что переданы путь директории
        } else {
            parentFile.mkdirs()   // знаем что передан файл. нужно перейти в директорию
            createNewFile()
        }
    }
}

fun writeDataToFile(data: Map<String, Double>, path: String) {
    val dataToString =
        data.map { "${it.key}=${it.value}" }.joinToString("\n")
    createFileOrDirectory(path)
    File(path).writeText(dataToString)
}

fun readTextAndTransform(path: String): Map<String, Double> {
    val file = File(path).readLines()
    return file.associate {
       val str = it.split("=")
        str[0] to str[1].toDouble()
    }
}

/*
Метод mkdirs() создаёт все необходимые родительские директории,
если их ещё нет
Метод createNewFile() создаёт сам файл, но только если его ещё не существует.
Если файл уже есть, он не изменяется и не перезаписывается.
Метод writeText() перезаписывает содержимое файла независимо от того,
существовал файл до этого или был создан только что.
 */