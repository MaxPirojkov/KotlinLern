package org.example.kotlinlern.lesson24.homeWork

/*
Задание 3.
Оберни все вызовы из предыдущего задания в блок try-catch
с одним блоком catch для любого типа исключений.
Внутри блока catch, используя when,
напиши для каждого исключения вывод в консоль специфического сообщения,
подходящего под каждый из типов.
 */

fun main() {
    val a = "123b"


    val list = listOf(1, 2, 3)
    try {
        val n = null as String //NullPointerException: null cannot be cast

        for (i in 0..list.size) {
            println(list[i]) // .ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        }

        a as Int       //ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer

        val i = "123,0".toDouble()     //NumberFormatException: For input string: "123,0"

        requireСond(-1) //IllegalArgumentException: Failed requirement.


        checkCond1(-1)    //IllegalStateException: Check failed.

        val bigNumber = IntArray(Int.MAX_VALUE) // OutOfMemoryError: Requested array size exceeds VM limit

        someFun1()          //StackOverflowError

    } catch (e: Throwable) {
        when (e) {
            is NullPointerException -> println("NullPointerException !")
            is ArrayIndexOutOfBoundsException -> println("$e !")
            is ClassCastException -> println("$e !")
            is NumberFormatException -> println("$e !")
            is IllegalArgumentException -> println("$e !")
            is IllegalStateException -> println("$e !")
            is OutOfMemoryError -> println("$e !")
            is StackOverflowError -> println("$e print")
            else -> println("Unknown error")
        }
    }

}

fun requireСond(item: Int) {
    require(item > 0)
}

fun checkCond1(item: Int) {
    check(item > 0)
}

fun someFun1() {
    somefun()
}