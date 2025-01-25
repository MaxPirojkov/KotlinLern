package org.example.kotlinlern.lesson18.homework2shape

class Square(val side: Double) : Shape() {
    override fun area(): Double {
        return side * side
    }
}