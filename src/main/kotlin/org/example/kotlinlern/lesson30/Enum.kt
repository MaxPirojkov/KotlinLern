package org.example.kotlinlern.lesson30

// Enum - перечисление, особый тип класса, для групп констант
// например дни недели

object NumsObject {
    const val ONE = "One"
    const val TWO = "Two"
    const val THREE = "Three"
}

enum class Nums {
    ONE,
    TWO,
    THREE,
    FOUR
}

fun main() {
    val t: Nums = Nums.ONE
    println(t)
    for (n in Nums.entries) { // entries возвращает список
        println(n)
    }

    DayOfWeek.FRIDAY.printDay()
}

fun printNum(nums: Nums) {
    when(nums) {
        Nums.ONE -> println(1)
        Nums.TWO -> println(2)
        Nums.THREE -> println(3)
        Nums.FOUR -> TODO()
    }
}

enum class DayOfWeek (val isWeekend: Boolean = true) {
    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    FRIDAY(false),
    SATURDAY,
    SUNDAY;

    fun printDay() {
        if (isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }
}

enum class CoffeeType(
    val cost: Double,
    val coffeeBase: String,
    val recommendedSugar: Int,
    val hasMilk: Boolean = false
) {
    ESPRESSO(2.50, "Espresso", 0),
    LATTE(3.00, "Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.50, "Americano", 0);

    fun description() = "The $coffeeBase ${if (hasMilk) "with" else "without"} milk costs \$cost and is best with $recommendedSugar spoon of sugar"
}
