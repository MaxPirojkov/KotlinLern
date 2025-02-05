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

class Fridge : DevicesTemperatureRegulatableOpenableForthTask() {

    fun setTempr(temp: Int) {
        when {
            (!checkPowerIsOn()) ->
                println("Холодильник выключен, необходимо включить холодильник для установки температуры")

            checkTempInRange(temp) -> setTemperature(temp)
            else -> println("Ошибка: $temp - Недопустимая температура. Допустимый диапазон: 0..$maxTemperature градусов")
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

    override var maxTemperature: Int = 0
}

fun main() {
    val myFridge = Fridge()
    myFridge.maxTemperature = 6
    myFridge.powerOn()
    myFridge.setTempr(4)
    myFridge.setProgram("Быстрая заморозка")
}