package org.example.kotlinlern.lesson18.homework3printer

class LaserPrinter : Printer() {

    override fun print(string: String) {
        splitStringFixColor(string)
    }
}