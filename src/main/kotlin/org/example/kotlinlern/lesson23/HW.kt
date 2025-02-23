package org.example.kotlinlern.lesson23

import org.example.kotlinlern.lesson11.addPairsToMap

/*
Задача 1
Напишите функцию analyzeDataType, принимающую параметр типа Any.
Функция должна определить тип аргумента и вывести соответствующее сообщение:
Для строки: "Это строка: [значение]".
Для целого числа: "Это целое число: [значение]".
Для списка: "Это список, количество элементов: [количество]".
Для карты: "Это карта, количество пар: [количество]".
Для остальных типов: "Неизвестный тип данных".
Используйте оператор is для проверки типов.
 */

fun analyzeDataType(item: Any) {
    when (item) {
        is String -> println("Это строка: $item")
        is Int -> println("Это целое число: $item")
        is List<*> -> println("Это список, количество элементов: ${item.size}")
        is Map<*, *> -> println("Это карта, количество пар: ${item.size}")
        else -> println("Неизвестный тип данных")
    }
}

/*
Задача 2
Создайте функцию safeCastToList,
принимающую параметр типа Any
и возвращающую размер списка,
если аргумент можно безопасно привести к типу List.
В случае неудачного приведения функция должна возвращать -1.
Используйте as? для безопасного приведения типа.
 */

fun safeCastToList(item: Any): Int {
    return (item as? List<*>)?.size ?: -1
}

/*
Задача 3
Создайте функцию getStringLengthOrZero,
которая принимает параметр типа Any?
и возвращает длину строки,
если аргумент можно привести к типу String.
В случае, если аргумент равен null
или не является строкой, функция должна возвращать 0.
 */

fun getStringLengthOrZero(item: Any?): Int {
    return (item as? String)?.length ?: 0
}

/*
Задача 4
Создайте функцию, которая принимает параметр типа Any.
Функция гарантированно ожидает число
(в виде числа или строки, например 4 или 4.2 или “4.2”)
и должна вернуть квадрат этого числа.
Если придёт число,
его нужно возвести в квадрат,
если придёт строка,
то его нужно преобразовать в число через функцию toDouble()
и возвести в квадрат.
 */

fun getSqure(item: Any): Double {
    return when (item) {
        is Number -> item.toDouble() * item.toDouble()
        is String -> {
            val square = item.toDoubleOrNull() ?: 0.0
            square * square
        }

        else -> 0.0
    }
}

/*
Задача 5
Напишите функцию sumIntOrDoubleValues,
которая принимает список элементов типа Any
и возвращает сумму всех целочисленных (Int)
и вещественных (Double) значений в списке.
Все остальные типы должны быть проигнорированы.
 */

fun sumIntOrDoubleValues(list: List<Any>): Double {
    return list.map {
        when (it) {
            is Int -> it.toDouble()
            is Double -> it
            else -> 0.0
        }
    }.sum()
}

/*
Задача 6
Создайте функцию tryCastToListAndPrint,
которая принимает параметр типа Any
и пытается привести его к типу List<*>.
Если приведение успешно,
функция должна напечатать все строки из списка,
если элемент не является строкой то вывести предупреждение об этом.
Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.
 */
fun tryCastToListAndPrint(item: Any) {
    (item as? List<*>)?.forEach {
        val res = (it as? String) ?: "$it is not string"
        println(res)
    } ?: println("item is not List")
}


fun main() {
    val str = "my string"
    val strN = "234"
    val numb = 123
    val myList = listOf("1", "2", "3")
    val myMap = mapOf(1 to "one", 2 to "two", 3 to "three")
    val double = 2.3
    analyzeDataType(str)
    analyzeDataType(numb)
    analyzeDataType(myList)
    analyzeDataType(myMap)
    analyzeDataType(double)

    println("--- Task2")
    println( safeCastToList(str)) //-1
    println(safeCastToList(myList))  // 3

    println("--- Task3")
    println(getStringLengthOrZero(str))
    println(getStringLengthOrZero(double))

    println("--- Task4")
    println(getSqure(numb))
    println(getSqure(str))
    println(getSqure(strN))
    println(getSqure(double))

    println("--- Task5")
    val list = listOf("1", 2, 3.0, "abc")
    println(sumIntOrDoubleValues(list))

    println("--- Task6")
    tryCastToListAndPrint(list)
}