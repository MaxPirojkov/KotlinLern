package org.example.kotlinlern.lesson22
/*
нельзя переорпределять методы
нет доступа к приватным, протектным функциям
обычно создается package extensions - и туда добавляются такие функции
 */

fun main() {
    // стандартное использование
    val result = removeSpaceA("String with spaces")

    //расширение
    val result1 = "String with spaces".removeSpacesB()

    val s: List<Int?> = listOf(1, 3, null)
    println( s.isElementsNullOrEmpty())

    println("example".funAa("one", 2))
    listOf(1, 2, 3).funBb("22")
    mapOf("1" to 1, "2" to 2).funC("3", 3)

    val num = 0.9
    num.funD(1.2, "111")

    setOf(1, 2, 4).funE(11)

    val myDouble = 58.12345
    //s - для строк, d -digit, f - чисел с плавающей точкой
    println("%.2f".format(myDouble))
    num.doubleFormat()

    val strOne = "What a great day"
    strOne.split(" ").size
    strOne.wordCounter()

    val num2 = 123

}

// в языках без расширения класса (стандартный подход)
fun removeSpaceA(str: String): String {
    return str.replace(" ", "")
}

// расширение класса String
fun String.removeSpacesB(): String {
    return this.replace("", "")
}

//сложнее пример с дженириками
fun <T> List<T?>.isElementsNullOrEmpty(): Boolean {
    return this.all { it == null } || this.isEmpty()
}

fun String.funAa(arg1: String, arg2: Int): Boolean {
    return true
}

fun List<Int>.funBb(arg1: String?) {}

fun <K, V> Map<K, V>.funC(arg1: K, arg2: V): Boolean {
    return true
}

fun Double?.funD(arg1: Double, arg2: String?): Double {
    return 0.0
}

fun <T> Set<T>.funE(arg1: T): List<T> {
    return listOf()
}

fun Double.doubleFormat(): String {
    return "%.2f".format(this)
}

fun String.wordCounter(): Int {
    return split(" ").size
}

fun <T> T.createList(n: Int): List<T> {
    return (0 until n).map { this }  //this - ссылается на объект к которому применяется функция createList
    // а если вместо this указать it - то it выводит значение из диапазона
}