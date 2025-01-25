package org.example.kotlinlern.lesson18.homework2shape

fun main() {
    val setOfShapes = setOf(
        Circle(5.0),
        Square(6.0),
        Triangle(2.0, 4.0, 60.0)
    )

    println( setOfShapes.forEach{it.area()} )
}