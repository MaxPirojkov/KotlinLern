package org.example.kotlinlern.lesson18.homework3printer

import org.example.kotlinlern.lesson18.homework.Background
import org.example.kotlinlern.lesson18.homework.Colors

fun main() {
    val exampleText = "Лазерный принтер должен разбивать фразу на слова по пробелу"

    val str = LaserPrinter()
    str.print(exampleText)

    val str2 = JetPrinter()
    println(str2.print(exampleText))
}