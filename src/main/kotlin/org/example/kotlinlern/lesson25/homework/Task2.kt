package org.example.kotlinlern.lesson25.homework

/*
Задание 2. Создай функцию, которая принимает список чисел
и возвращает среднее арифметическое этого списка.
С помощью require проверь, что список не пустой.
Создай аналогичную анонимную функцию.
Создай аналогичное лямбда выражение с указанием типа.
Создай лямбда выражение без указания типа.
Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).
 */

fun main() {
    val list = listOf(1, 2, 4)
    val list2: List<Int> = listOf()

    val function12 = fun(list: List<Int>): Double {
        require(list.isNotEmpty()) { "list is empty" }
        return list.average()
    }

    val function13: (List<Int>) -> Double = {
        require(it.isNotEmpty()) { "list is empty" }
        it.average()
    }

    val function14 = { someList: List<Int> ->
        require(someList.isNotEmpty()) { "list is empty" }
        someList.average()
    }
}

fun function1(list: List<Int>): Double {
    require(list.isNotEmpty()) { "list is empty" }
    return list.average()
}