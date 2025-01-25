package org.example.kotlinlern.lesson18.homework

import org.example.kotlinlern.lesson18.homework.Colors

fun main() {

    val listAnimal = listOf(Cat(), Dog(), Bird())
    listAnimal.forEach { it.makeSound() }
}