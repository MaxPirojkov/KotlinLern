package org.example.kotlinlern.lesson18.homework3printer

import org.example.kotlinlern.lesson18.homework.Colors

abstract class Printer {
    abstract fun print(string: String)

    protected fun printText(str: String, color: String, backgroundColor: String) {
        val words = str.split(" ")
        words.forEach { word -> printColoredBack(word, color, backgroundColor) }
    }

    private fun printColoredBack(text: String, color: String, backgroundColor: String) {
        println("$color$backgroundColor$text${Colors.RESET}")
    }
}