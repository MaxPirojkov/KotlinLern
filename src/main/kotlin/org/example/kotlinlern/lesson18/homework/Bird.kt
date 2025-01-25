package org.example.kotlinlern.lesson18.homework

import org.example.kotlinlern.lesson18.printColored

class Bird : Animal() {
    override fun makeSound() {
        printColored("Tweet", Colors.YELLOW)
    }
}