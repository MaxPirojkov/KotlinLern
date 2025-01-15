package org.example.kotlinlern.lesson15
// сущность является и классом и объектом
// в объекте нет конструктора - то что указывается в скобках после названия объекта
object Logger {

    fun log(message: String) {
        println("Log: $message")
    }
}