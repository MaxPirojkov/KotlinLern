package org.example.kotlinlern.lesson18.homework3printer

import org.example.kotlinlern.lesson18.homework.Background
import org.example.kotlinlern.lesson18.homework.Colors

class JetPrinter : Printer() {
    override fun print(string: String) {
        val words = string.split(" ")
        var colorIndex = 0

        for (word in words) {
            val textColor = colorPairs[colorIndex].first
            val background = colorPairs[colorIndex].second
            printText(word, textColor, background)
            colorIndex++
            if (colorIndex >= colorPairs.size) {
                colorIndex = 0
            }
        }
    }

    private val colorPairs: List<Pair<String, String>> = listOf(
        Colors.BLUE to Background.BG_YELLOW,
        Colors.YELLOW to Background.BG_BLUE,
        Colors.RED to Background.BG_WHITE,
        Colors.GREEN to Background.BG_WHITE,
        Colors.CYAN to Background.BG_BLACK,
        Colors.BLACK to Background.BG_WHITE,
        Colors.WHITE to Background.BG_BLACK
    )
}



