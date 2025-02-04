package org.example.kotlinlern.lesson20.homework.fifthtask

import org.example.kotlinlern.lesson20.homework.*

class Kettle : DevicesTemperatureRegulatableOpenableForthTask(), WaterContainer, AutomaticShutdown, Timable {

    override var maxTemperature: Int
        get() = 100
        set(value) {}


    override fun setTemperature(temp: Int) {
        println("$temp - установлена температура для нагрева")
    }

    override val capacity: Int
        get() = 1500

    override fun fillWater(amount: Int) {
        println("Заливается вода объемом $amount")
    }

    override fun getWater(amount: Int) {
        println("Наливается вода объемом $amount")
    }

    override val sensorType: String
        get() = "Датчик температуры"
    override val maxSensoredValue: Int
        get() = 100

    override fun startMonitoring() {
        println("Старт мониторинга")
    }

    override fun setTimer(time: Int) {
        println("установлен таймер на $time")
    }

    fun fillKettle(capacity: Int, amount: Int) {
        when {
            !checkIsOpen() -> println("Крышка закрыта, откройте крышку перед тем как налить воды")
            !freeSpaceInKettle(capacity, amount) -> println("Попробуйте налить меньше")
            freeSpaceInKettle(capacity, amount) -> println("В чайник добавлено воды объемом $amount")
        }
    }

    fun freeSpaceInKettle(capacity: Int, amount: Int): Boolean {
        return (capacity - amount) > 0 && capacity > amount
    }

    fun boilingWater(temp: Int) {
        when {
            !checkPowerIsOn() -> println("Чайник выключен")
            (!checkIsOpen() && checkPowerIsOn() && checkSetTemperature(temp)) -> setTemperature(temp)
            else -> println("Закройте крышку перед нагревом воды")
        }
    }
}

fun main() {
    val kettle = Kettle()
    kettle.isOpen = true
    kettle.fillKettle(1000, 100)
    kettle.isOn = true
    kettle.isOpen = false
    kettle.boilingWater(100)
}