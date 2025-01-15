package org.example.kotlinlern.lesson15

class Wind(val speedKmHour: Int) {
    fun convertMetrSec(): Int {
        return speedKmHour * 1000 / 3600
    }
}