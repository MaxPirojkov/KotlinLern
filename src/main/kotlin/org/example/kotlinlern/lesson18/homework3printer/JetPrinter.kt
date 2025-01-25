package org.example.kotlinlern.lesson18.homework3printer

import org.example.kotlinlern.lesson18.homework.Background
import org.example.kotlinlern.lesson18.homework.Colors

class JetPrinter : Printer() {
    override fun print(string: String) {

        splitStringRandomColor(
            string, listOfColors
        )
    }
    val listOfColors: List<Pair<String, String>> = listOf(
        Colors.BLUE to Background.BG_YELLOW,
        Colors.YELLOW to Background.BG_BLUE,
        Colors.RED to Background.BG_WHITE,
        Colors.GREEN to Background.BG_WHITE,
        Colors.CYAN to Background.BG_BLACK,
        Colors.BLACK to Background.BG_WHITE,
        Colors.WHITE to Background.BG_BLACK
    )
}



