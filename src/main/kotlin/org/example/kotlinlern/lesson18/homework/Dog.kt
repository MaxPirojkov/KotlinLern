package org.example.kotlinlern.lesson18.homework

import org.example.kotlinlern.lesson18.printColored

class Dog : Animal() {
    override fun makeSound() {
        printColored("Bark", Colors.CYAN)
    }
}