package org.example.kotlinlern.lesson20.homework.fifthtask

import org.example.kotlinlern.lesson20.homework.DevicesTemperatureRegulatableOpenableForthTask
import org.example.kotlinlern.lesson20.homework.Timable

class Oven: DevicesTemperatureRegulatableOpenableForthTask(), Timable {


    override fun setTimer(time: Int) {
        println("Установлен таймер $time")
    }

    fun putTheFood() {
        when {
            !checkIsOpen() -> println("Откройте дверцу духовки")
            else -> println("Поставье еду в духовку")
        }
    }

    fun startCookingOven(temp: Int) {
        when {
            checkIsOpen() -> println("Дверца духовки открыта")
            !checkPowerIsOn() -> println("Включите электричество")
            (!checkIsOpen() && checkPowerIsOn() && checkSetTemperature(temp)) -> setTemperature(temp)
            else -> println("Установлена температура больше максимальной")
        }
    }

    override var maxTemperature: Int
        get() = 300
        set(value) {}

}

fun main() {
    val oven = Oven()
    oven.isOpen = false
    oven.isOn = true
    oven.startCookingOven(250)
}