package org.example.kotlinlern.lesson18.homework3printer

fun main() {
    val exampleText = "Лазерный принтер должен разбивать фразу на слова по пробелу"

    val str = LaserPrinter()
    str.print(exampleText)

    val str2 = JetPrinter()
    println(str2.print(exampleText))
}