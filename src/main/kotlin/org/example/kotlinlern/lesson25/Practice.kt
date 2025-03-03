package org.example.kotlinlern.lesson25

fun main() {
    val function = fun() {
        println("Hello")
    }

    val function1 = { println("Hello") }

    val function2 = fun(a: String): Int {
        return a.length
    }

    val function3: (String) -> Int = {
        it.length
    }

// упрощенная(сокращенная) запись лямбда выражения
    val function4 = { str: String ->
        str.length
    }

    val function5 = fun String.(a: Int, b: Int): Boolean {
        println(this)
        println(a)
        println(b)
        return a == b
    }
    // когда мы расширяем функцию, сокращенного вида не получится
    val function6: String.(Int, Int) -> Boolean = { a: Int, b: Int ->
        println(this)
        println(a)
        println(b)
        a == b
    }

    val myStr = "Hello"
    println(myStr.function6(1, 3))

    val func1 = fun(list: List<Int>): Int {
        return list.filter { it > 0 }.sum()
    }

    val func2: (List<Int>) -> Int = { list ->
        list.filter { it > 0 }.sum()
    }

    val func3 = { list: List<Int> ->
        list.filter { it > 0 }.sum()
    }

    val func4 = fun Set<Int>.(): Set<Int> {
        return filter { it % 2 == 0 }.toSet()
    }

    val func5: Set<Int>.() -> Set<Int> = {
        filter { it % 2 == 0 }.toSet()
    }

    val set = setOf(1, 3, 4, 5)
    println( set.func5()) // 4

    // сделать анонимную функицию с дженериком нельзя


}


fun function() {
    println("Hello")
}

fun function1(a: String): Int {
    return a.length
}

fun String.function2(a: Int, b: Int): Boolean {
    println(this)
    println(a)
    println(b)
    return a == b
}

fun func(list: List<Int>): Int {
    var numb = 0
    return list.filter { it > 0 }.sum()
}

fun Set<Int>.func2(): Set<Int> {
    return filter { it % 2 == 0 }.toSet()
}

fun <T> func3(a: T) {
    println(a)
}