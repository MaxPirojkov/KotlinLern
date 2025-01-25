package org.example.kotlinlern.lesson18.homework

import org.example.kotlinlern.lesson18.printColored

class Cat : Animal() {
    override fun makeSound() {
        printColored("Meow", Colors.RED)
    }
}