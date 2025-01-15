package org.example.kotlinlern.lesson15

class Lamp(var isOn: Boolean) {
    fun switcher() {
        isOn = !isOn
        println(isOn)
    }
}