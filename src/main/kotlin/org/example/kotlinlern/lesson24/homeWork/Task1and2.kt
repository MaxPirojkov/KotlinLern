package org.example.kotlinlern.lesson24.homeWork
/*
Задание 1. Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
NullPointerException
ArrayIndexOutOfBoundsException
ClassCastException
NumberFormatException
IllegalArgumentException
IllegalStateException
OutOfMemoryError
StackOverflowError
*/

fun main() {
    val s: String? = null
    val list = listOf(1, 2, 3)
    val a = "123b"


    try {
       s!!.length //NullPointerException: null cannot be cast
    } catch (e: NullPointerException) {
        println("$e !")
    }

    try {
        for (i in 0 .. list.size ){
            list[i] // .ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        }    } catch (e: ArrayIndexOutOfBoundsException) {
        println("ArrayIndexOutOfBoundsException !")
    }

    try {
        a as Int       //ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer
    } catch (e: ClassCastException) {
        println("ClassCastException !")
    }


    try {
        val i = "123,0".toDouble()     //NumberFormatException: For input string: "123,0"
    } catch (e: NumberFormatException) {
        println("NumberFormatException !")
    }

    try {
        requiredСond(-1) //IllegalArgumentException: Failed requirement.
    } catch (e: IllegalArgumentException) {
        println("IllegalArgumentException !")
    }

    try {
        checkCond(-1)    //IllegalStateException: Check failed.
    } catch (e: IllegalStateException) {
        println("IllegalStateException !")
    }


    try {
        val bigNumber = IntArray(Int.MAX_VALUE) // OutOfMemoryError: Requested array size exceeds VM limit
    } catch (e: OutOfMemoryError) {
        println("OutOfMemoryError !")
    }


    try {
        somefun()          //StackOverflowError
    } catch (e: StackOverflowError) {
        println("StackOverFlow")
    }

}

fun requiredСond(item: Int) {
    require(item > 0)
}

fun checkCond(item: Int) {
    check(item > 0)
}

fun somefun() {
    somefun()
}

/*
Задание 2. Оберни все вызовы из предыдущего задания в блок try-catch
и создай для каждого типа ошибки свой catch блок
 */