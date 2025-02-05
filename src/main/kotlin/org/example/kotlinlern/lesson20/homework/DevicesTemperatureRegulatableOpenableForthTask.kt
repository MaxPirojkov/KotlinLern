package org.example.kotlinlern.lesson20.homework
/*
Создай абстрактный класс
оборудования с возможностью устанавливать температуру
и открываться
и с наследованием от программируемого оборудования.
Также имплементируй интерфейсы.
 */

abstract class DevicesTemperatureRegulatableOpenableForthTask : ProgrammableDevicesThirdTask(), TemperatureRegulatable,
    Openable {

    private var isOpen: Boolean = false

    private var currentTemperature: Int = 0

    fun checkIsOpen(): Boolean {
        return isOpen
    }

    abstract override var maxTemperature: Int

    override fun setTemperature(temp: Int) {
        currentTemperature = temp
        println("Установлена температура $temp")
    }
    fun checkTempInRange(temp: Int): Boolean{
        return temp in 0..maxTemperature
    }

    fun checkSetTemperature(temp: Int): Boolean {
        currentTemperature = temp
        return (maxTemperature - currentTemperature) >= 0
    }

    override fun open() {
        isOpen = true
    }

    override fun close() {
        isOpen = false
    }
}