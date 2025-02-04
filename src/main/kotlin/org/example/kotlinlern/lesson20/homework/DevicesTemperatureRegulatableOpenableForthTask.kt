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


    open var isOpen: Boolean = false

    open var isOn: Boolean = false

    private var currentTemperature: Int = 0

    fun checkPowerIsOn(): Boolean {
        return isOn
    }

    fun checkIsOpen(): Boolean {
        return isOpen
    }

    abstract override var maxTemperature: Int


    override fun setTemperature(temp: Int) {
        currentTemperature = temp
        println("Установлена температура $temp")
    }

    fun checkSetTemperature(temp: Int): Boolean {
        currentTemperature = temp
        return (maxTemperature - currentTemperature) >= 0
    }

    override fun powerOn() {
        isOn = true
    }

    override fun powerOff() {
        isOn = false
    }

    override fun open() {
        isOpen = true
    }

    override fun close() {
        isOpen = false
    }
}