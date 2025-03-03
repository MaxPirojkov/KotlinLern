package org.example.kotlinlern.lesson25.homework

/*
Задание 5. Создай функцию расширение списка чисел,
которая будет возвращать список уникальных чисел (без дубликатов).
Создай аналогичную анонимную функцию.
Создай аналогичное лямбда выражение с указанием типа.
Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.
 */

fun main() {
    val list: List<Int> = listOf(1, 2, 2, 4)

    val function51 = fun List<Int>.(): List<Int> {
        require(this.isNotEmpty()){"список пуст"}
        return distinct()
    }

    val function52: List<Int>.()-> List<Int> = {
        require(this.isNotEmpty()){"список пуст"}
        distinct()
    }

    println( list.function52())
}

fun List<Int>.function5(): List<Int>{
    require(this.isNotEmpty()){"список пуст"}
    return distinct()
}