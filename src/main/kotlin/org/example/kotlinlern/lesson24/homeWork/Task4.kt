package org.example.kotlinlern.lesson24.homeWork

import org.example.kotlinlern.lesson24.CatchException

fun main() {

    val isOn = true

    checkIsOn(isOn)

}

fun checkIsOn(value: Boolean) {
    if (value) {
        throw CatchException("Ошибка состояния")
    }
}