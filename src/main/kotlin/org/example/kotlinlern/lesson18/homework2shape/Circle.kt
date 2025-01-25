package org.example.kotlinlern.lesson18.homework2shape

class Circle(val radius: Double) : Shape() {
    override fun area(): Double {
        return 3.14 * radius
    }
}