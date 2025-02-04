package org.example.kotlinlern.lesson20.homework
/*
Создай абстрактный класс для программируемого оборудования
(с имплементацией соответствующего интерфейса и реализацией методов)
и наследуй его от абстрактного класса включаемого оборудования.

 */

abstract class ProgrammableDevicesThirdTask: PowerableDevicesSecondTask(),  Programmable {
    override fun programAction(action: String) {
        println("Program action is $action")
    }
    override fun execute() {
        println("Program is execute")
    }


}