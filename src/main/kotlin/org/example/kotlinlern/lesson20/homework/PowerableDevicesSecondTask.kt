package org.example.kotlinlern.lesson20.homework
/*
Создай абстрактный класс для включаемого оборудования
и имплементируй соответствующий интерфейс
с реализацией методов (достаточно println с выполняемым действием).
 */

abstract class PowerableDevicesSecondTask : Powerable {

    private var isOn: Boolean = false

    override fun powerOn() {
        isOn = true
    }

    override fun powerOff() {
        isOn = false
    }

    fun checkPowerIsOn(): Boolean {
        return isOn
    }
}