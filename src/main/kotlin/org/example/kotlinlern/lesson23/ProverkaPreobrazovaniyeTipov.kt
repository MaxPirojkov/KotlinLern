package org.example.kotlinlern.lesson23

import org.example.kotlinlern.lesson7.loopUpEven

// Проверка и преобразование типов

// проверка типов - происходит через is
fun main() {


    val obj: Any = "Hello"

    if (obj is String) {
        println("Объект яв-ся Строкой")
    }

    if (obj !is Int) {
        println("Объект не яв-ся Числом")
    }

    if (obj is String) {
        //obj автоматически приведен к String
        println(obj.uppercase())  //method .uppercase() is allowed because obj is String
    }

    // преобразование типа
    // позволяет изменить тип из одного в другой
    val num: Any = 123
//    val str: String = num as String
    num as Int // мы говорим что объект  num является Int
    val safeStr: String? = num as? String //безопасное преобразование типов. Вывод null


    val mixedList: List<Any> = listOf("Kotlin", 42, 3.14, "Java", true)

    for (item in mixedList) {
        when (item) {
            is String -> println("$item - string length ${item.length}")
            is Int -> println("$item - type Int")
            else -> println("Unknown type $item")
        }
    }

    val flyingC = FlyingCar()
    val car = Car()
    checkCapabilities(flyingC)
    checkCapabilities(car)


    val myString: Any = "abcd"
    println(myString as String)
    //      println(i as Int) // ошибка так как i не может быть Int
    if (myString is String) {
        println(myString)
    } else {
        println("is not String")
    }

    // способ с безопасным оператором приведения типов
    println(myString as? Int) // вывод null
    println(myString as? Int ?: "is not numb") // выведет is not numb

    val j: Any = listOf("Hello", "world", "kotlin")
    println(j as List<Int>)
    //  println((j as List<Int>)[0]) ошибка выводися так как в этот момент происходит привидения типов
    if (j is List<*>) {
        (j[0] as String).length
    }

    val i: String? = null
    println(i as? String)
}

interface Drivable {
    fun drive()
}

interface Flyable {
    fun fly()
}

class Car : Drivable {
    override fun drive() {
        println("Едет как автомобиль")
    }
}

class FlyingCar : Drivable, Flyable {
    override fun drive() {
        println("Едет как автомобиль")
    }

    override fun fly() {
        println("Летит как самолет")
    }
}

fun checkCapabilities(drivable: Drivable) {
    drivable.drive()

    if (drivable is Flyable) { // после проверки объект гарантировано становится типом Flyable
        println("этот объект тоже может летать")
        drivable.fly()
    } else {
        // тут уже не вызвать функцию drivable.fly() - будет ошибка
        println("Этот объект не может летать")
    }
}
