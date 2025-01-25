package org.example.kotlinlern.lesson18
import org.example.kotlinlern.lesson18.homework.Colors

class TheoryPolimorfism {
    // перегрузка - один и тот же метод может принимать разное кол-во или разные типы параметров
    // пример: класс монитор
    // несколько портов wga, hdmi - один и тот же метод но разные типы данных


    // переопределение - когда класс изменяет метод из наследуемого класса
    // пример: способ вывода на экран одинаковый, но реализован по разному
}




fun printColored(text: String, color: String, backgroundColor: String = "") {
    println("$color$backgroundColor$text${Colors.RESET}")
}



abstract class MusicalInstrument {
    abstract fun playNote(note: String)

    protected fun shortNote(note: String, color: String) {
        printColored("Play short note $note", color)
    }

    protected fun longNote(note: String, color: String) {
        printColored("Play long note $note", color)
    }
}

// переопределение
class Cello : MusicalInstrument() {
    override fun playNote(note: String) {
        longNote(note, Colors.RED)
    }
}

class Piano : MusicalInstrument() {
    override fun playNote(note: String) {
        shortNote(note, Colors.GREEN)
    }
}

fun main() {
    val orchestra = listOf(Cello(), Piano())
    orchestra.forEach { it.playNote("Do") }

    val calc = Calc()

    println(calc.sum(1, 2))
    println(calc.sum("3", "4"))
    println(calc.sum(2.0, 4.1))
    println(calc.sum(listOf(1, 2, 3), listOf(5, 6)))
    println(calc.sum("1", "true"))
}

//перегрузка
class Calc {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum(a: Double, b: Double): Double {
        return a + b
    }

    fun sum(a: String, b: String): String {
        return a + b
    }

    fun sum(a: List<Int>, b: List<Int>): List<Int> {
        return a + b
    }

    fun sum(a: String, b: Boolean): String {
        return a + b.toString()
    }
}