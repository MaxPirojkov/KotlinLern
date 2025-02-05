package org.example.kotlinlern.lesson20.homework.fifthtask

import org.example.kotlinlern.lesson20.homework.*

/*
Создай не абстрактные классы устройств
с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться.
Пусть это будет стир маш.
Добавь недостающие интерфейсы
и реализуй необходимые методы (достаточно вывод в консоль производимого действия).
Обрати внимание на то, что установка температуры и программирование устройства
(считай - задание режима работы)
не имеет смысла при выключенном питании - добавь эту проверку.
 */
class WashingMachine : DevicesTemperatureRegulatableOpenableForthTask(), WaterContainer, AutomaticShutdown,
    Drainable, Timable, Cleanable {

    fun washing(temp: Int, time: Int) {
        when {
            (!checkPowerIsOn()) -> println("Cтиральная машина выключена, необходимо включить для запуска программы")
            (checkPowerIsOn() && checkIsOpen()) -> println("Загрузите белье и выберете программу")
            (checkPowerIsOn() && !checkIsOpen()) -> startWashing(temp, time)
        }
    }

    private fun startWashing(temp: Int, time: Int): String {
        if (checkSetTemperature(temp)) setTemperature(temp)
        setTimer(time)
        startMonitoring()
        connectToDrain()
        return println("Стирка началась").toString()
    }

    override var maxTemperature: Int = 80

    override val capacity: Int = 5

    override fun fillWater(amount: Int) {
        println("Вода набирается объемом $amount")
    }

    override fun getWater(amount: Int) {
        println("Наполнить объемом воды - $amount")
    }

    override val sensorType: String
        get() = "Датчики протечки"

    override val maxSensoredValue: Int
        get() = 100

    override fun startMonitoring() {
        println("Проверка систем контроля")
    }

    override fun connectToDrain() {
        println("Проверка соединения к дренажу")
    }

    override fun drain() {
        println("Спуск воды в дренаж")
    }

    override fun setTimer(time: Int) {
        println("Выбрана программа со временем  $time")
    }

    override fun clean() {
        println("Очистка барабана")
    }
}

fun main() {
    val washMachine = WashingMachine()
    washMachine.powerOn()
    washMachine.open()
    washMachine.washing(40, 80)
    washMachine.close()
    washMachine.washing(40, 80)
}