package org.example.kotlinlern.lesson20.homework.fifthtask

import org.example.kotlinlern.lesson20.homework.DevicesTemperatureRegulatableOpenableForthTask
import org.example.kotlinlern.lesson20.homework.Programmable

/*
Создай не абстрактные классы устройств
с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться.
Пусть это будет холодильник.
Добавь недостающие интерфейсы
и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
Обрати внимание на то, что установка температуры и программирование устройства
(считай - задание режима работы)
не имеет смысла при выключенном питании - добавь эту проверку.

 */

class Fridge : DevicesTemperatureRegulatableOpenableForthTask(), Programmable {

    override var maxTemperature: Int = 0

    override fun setTemperature(temp: Int) {
        println("$temp is set")
    }

    override fun open() {
        println("Дверца открыта")
    }

    override fun close() {
        println("Дверца закрыта")
    }

    override fun powerOn() {
        isOn = true
        println("Холодильник включен")
    }

    override fun powerOff() {
        isOn = false
        println("Холодильник выключен")
    }

    override fun programAction(action: String) {
        println("$action программа запущена")
    }

    override fun execute() {
        println("Программа выполнена")
    }


    fun setTempr(temp: Int) {
        when {
            (!checkPowerIsOn()) ->
                println("Холодильник выключен, необходимо включить холодильник для установки температуры")

            (temp in maxTemperature..6) ->
                println("Температура установлена на $temp")

            else -> println("Ошибка: $temp - Недопустимая температура. Допустимый диапазон: 6..$maxTemperature градусов")
        }
    }

    fun setProgram(action: String) {
        when {
            (!checkPowerIsOn()) ->
                println("Холодильник выключен, необходимо включить холодильник для установки температуры")

            checkPowerIsOn() -> {
                programAction(action)
                execute()
            }
        }
    }
}

fun main() {
    val myFridge = Fridge()
    myFridge.maxTemperature = 2
    myFridge.powerOn()
    myFridge.setTempr(3)
    myFridge.setProgram("Быстрая заморозка")
}