package org.example.kotlinlern.lesson25

// сделать анонимную функицию с дженериком нельзя

fun main() {
    // объявление функции через переменную
    val increment = fun(a: Int): Int {
        return a + 1
    }

    // lambda. принимает оргумент -> тип возвращаемого значение = {тело функции}
    val increment1: (Int) -> Int = { a -> a + 1 }

    val increment2: (a: Int) -> Int = { it + 1 }

    println(increment2(2))

    increment(1)  // ссылка на объект, которая ссылается на функцию


    //принимаемый аргумент в теле функции -> возвращаемый тип определяется автоматически
    val increment3 = { a: Int -> a + 1 }

    //трансофрмация fun findIndex
    val findIndex = fun(text: String, word: String, ignoreCase: Boolean): Int {
        return text.indexOf(word, 0, ignoreCase)
    }

    val findIndex1: (String, String, Boolean) -> Int = { text, word, ignoreCase ->
        text.indexOf(word, 0, ignoreCase)
    }

    val findIndex2 = { text: String, word: String, ignoreCase: Boolean ->
        text.indexOf(word, 0, ignoreCase)
    }

    println(findIndex("I love Kotlin", "love", false))

    val calculateDeliveryTime = fun OrderProessor.(productId: Int): String {
        val deliveryTimeDays = when (productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays по адресу $deliveryAddress"
    }

    // ламбда выражение
    val calculateDeliveryTime1: OrderProessor.(Int) -> String = {
        val deliveryTimeDays = when (it) {
            in 1..100 -> 3
            else -> 5
        }
        "Ожидаемая дата доставки: через $deliveryTimeDays по адресу $deliveryAddress"
    }

    val op = OrderProessor("my address")
    calculateDeliveryTime1(op, 33)
    op.calculateDeliveryTime1(34)

    fun OrderProessor.calculateDeliveryTime(productId: Int): String {
        val deliveryTimeDays = when (productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays по адресу $deliveryAddress"
    }


}

//обычное объявление
fun increment(a: Int): Int {
    return a + 1
}

fun findIndex(text: String, word: String, ignoreCase: Boolean = false): Int {
    return text.indexOf(word, 0, ignoreCase)
}

class OrderProessor(val deliveryAddress: String) {
    fun calculateDeliveryTime(productId: Int): String {
        val deliveryTimeDays = when (productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays по адресу $deliveryAddress"
    }
}