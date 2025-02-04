package org.example.kotlinlern.lesson18.homework3printer

import org.example.kotlinlern.lesson18.homework.Background
import org.example.kotlinlern.lesson18.homework.Colors

class LaserPrinter : Printer() {

    override fun print(string: String) {
        printText(string, Colors.BLACK, Background.BG_WHITE)
    }

}