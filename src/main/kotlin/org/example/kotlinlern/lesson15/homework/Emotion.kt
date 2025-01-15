package org.example.kotlinlern.lesson15.homework

class Emotion(val type: String, private val intensity: Int) {
    fun express() {
        when (intensity) {
            in 1..9 -> println("Emotion 1")
            in 10..29 -> println("Emotion 2")
            in 29..49 -> println("Emotion 3")
            in 49..69 -> println("Emotion 4")
            in 70..89 -> println("Emotion 5")
            in 90..100 -> println("Emotion 9")
            else -> println("chill")
        }
    }
}