package org.example.kotlinlern.lesson25.homework
/*
Задание 1. Создай константу в файле с текстом. Создай функцию, которая ничего не принимает и не возвращает и печатает в консоль текст константы.
Создай аналогичную анонимную функцию.
Создай аналогичное лямбда выражение с указанием типа.
Создай лямбда выражение без указания типа.
Проверь как функция работает
 */
const val STR = "Some String"

fun main() {
    val function = fun() { println(STR) }

    val function1: () -> Unit = { println(STR) }

    val function2 = { println(STR) }

    function()
    function1()
    function2()


}

fun function() {
    println(STR)
}