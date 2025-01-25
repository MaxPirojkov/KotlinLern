package org.example.kotlinlern.lesson18.homework3printer

import org.example.kotlinlern.lesson18.homework.Background
import org.example.kotlinlern.lesson18.homework.Colors
import kotlin.random.Random

abstract class Printer {
    abstract fun print(string: String)

    protected fun splitStringFixColor(string: String){
        string
            .split(" ")
            .forEach{printColoredBack(it, Colors.BLACK, Background.BG_WHITE)}
    }

    protected fun splitStringRandomColor(string: String, listColor: List<Pair<String, String>> ){
        string
            .split(" ")
            .forEach{printColoredBack(it, randomColor(listColor).first, randomColor(listColor).second)}
    }

    private fun printColoredBack(text: String, color: String, backgroundColor: String) {
        println("$color$backgroundColor$text${Colors.RESET}")
    }

    private fun randomColor(list: List<Pair<String, String>>): Pair<String, String> {
        val random = Random.nextInt(list.size)
        return list[random]
    }
}