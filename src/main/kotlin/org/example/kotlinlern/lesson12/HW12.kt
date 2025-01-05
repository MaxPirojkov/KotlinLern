package org.example.kotlinlern.lesson12

import org.example.kotlinlern.lesson11.floatDoubleMap

fun main() {
    val lst = listOf(1, 2, 3, -4, 5, 6)
    val stringLst = listOf("One", null, "Three")
//    avarFun(lst)
//    isEven(4)
//    findFirstNegative(lst)
//    drawRectangle(3, 3)
}

/*
Напиши валидную сигнатура метода
Напишите сигнатуру функции, которая не принимает аргументов и не возвращает значения.
*/
fun emptyFun() {
}

/*
Напишите сигнатуру функции, которая принимает два целых числа и возвращает их сумму.
*/
fun sum(numb1: Int, numb2: Int): Int {
    return numb1 + numb2
}

/*
Напишите сигнатуру функции, которая принимает строку и ничего не возвращает.
*/
fun stringFun(str: String) {

}

/*
Напишите сигнатуру функции, которая принимает список целых чисел и возвращает среднее значение типа Double.

fun avarFun(list: List<Int>): Double {
}

Напишите сигнатуру функции, которая принимает nullable строку и возвращает её длину в виде nullable целого числа.
*/
fun nullFun(str: String?): Int? {
    return str?.length
}

/*
Напишите сигнатуру функции, которая не принимает аргументов и возвращает nullable вещественное число.

fun floatFun(): Float? {

}

Напишите сигнатуру функции, которая принимает nullable список целых чисел и не возвращает значения.
*/
fun nullFun(list: List<Int>?) {
}

/*
Напишите сигнатуру функции, которая принимает целое число и возвращает nullable строку.
fun intNull(numb: Int): String? {
}

Напишите сигнатуру функции, которая не принимает аргументов и возвращает список nullable строк.
fun listNull(): List<String?> {
}

Напишите сигнатуру функции, которая принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun nullString(str: String?, numb: Int?): Boolean? {
}
 */

/*
Напиши рабочий код для следующих задач: //  */ /*
Задача 1:
Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
*/
fun multiplyByTwo(numb: Int) = numb * 2

/*
Задача 2:
Создайте функцию isEven, которая принимает целое число
и возвращает true, если число чётное, и false в противном случае.
*/
fun isEven(numb: Int) = numb % 2 == 0

/*
Задача 3:
Напишите функцию printNumbersUntil, которая принимает целое число n
и выводит на экран числа от 1 до n.
Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
*/
fun printNumbersUntil(n: Int) {
    if (n < 1) {
        return
    }
    for (i in 1..n) {
        println(i)
    }

}

/*
Задача 4:
Создайте функцию findFirstNegative,
которая принимает список целых чисел
и возвращает первое отрицательное число в списке.
Если отрицательных чисел нет, функция должна вернуть null.
*/
fun findFirstNegative(list: List<Int>): Int? {
    for (i in list) {
        if (i < 0) {
            return i
        }
    }
    return null
}


/*
Задача 5:
Напишите функцию processList,
которая принимает список строк.
Функция должна проходить по списку
и выводить каждую строку.
Если встречается null значение,
функция должна прекратить выполнение с помощью return без возврата значения.
*/
fun processList(list: List<String?>) {
    for (i in list) {
        if (i == null) {
            return
        } else {
            println(i)
        }
    }
}
/*
Сделай рефакторинг функции,
через определение вспомогательных приватных функций.
Требуется избавиться от дублирования кода и трудно воспринимаемых фрагментов.

Сначала сделай запуск функции
и посмотри на результат её работы.
Сделай запуск после рефакторинга
и проверь, чтобы результат работы был аналогичным.
3, 3
+-+
| |
+-+
*/

private fun drawRct(value: Int, nameValue: String) {
    if (value <= 0) throw IllegalArgumentException("$nameValue должно быть положительным и больше нуля")
}

private fun drawHorizonBorder(width: Int) {
    var line = "+"
    for (i in 1 until width - 1) {
        line += "-"
    }
    line += "+\n"
    print(line)
}

fun drawRectangle(width: Int, height: Int) {
    drawRct(width, "width")
    drawRct(height, "height")

    // Верхняя граница
    drawHorizonBorder(width)

    // Боковые границы
    for (i in 1 until height - 1) {
        var middleLine = "|"
        for (j in 1 until width - 1) {
            middleLine += " "
        }
        middleLine += "|\n"
        print(middleLine)
    }

    // Нижняя граница
    drawHorizonBorder(width)
}
