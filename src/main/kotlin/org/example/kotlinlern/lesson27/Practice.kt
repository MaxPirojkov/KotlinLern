package org.example.kotlinlern.lesson27

fun main() {
    val list = mutableListOf(1, 2, 4)

    list.add(5)
    println(list)

    val list1 = list.toList()

    // лямбда функция автотматически расширеят тип  fun <T, R> with(receiver: T, block: T.() -> R): R
    val list2 = with(mutableListOf(1, 2, 3)) {
        list.add(7)
        println(this)
        toList()
    }

    val sb = StringBuilder() //позволяет собирать большие строки
    sb.append(333)
    sb.append("abv")
    sb.length


    //fun <T, R> T.run(block: T.() -> R): R {}     run расширяет тип данных
    val sb1 = StringBuilder().run {
        append("one")
        append("two")
        append("three")
        length
    }

    val list3 = arrayListOf<String>()
    list3.add("one")
    list3.add("two")

    // T.apply(block: T.() -> Unit): T    не меняет тип. в аргумент() передается лямбда функция-которая ничего не возвращает.
    val list4 = arrayListOf<String>().apply {
        add("three")
        add("four")
    }

    val list5 = arrayListOf<String>().also {
        it.add("three")
        it.add("four")
    }

    val strNull: String? = "abvgde"
    strNull?.length
    println(strNull?.length)
    println(strNull?.isEmpty())
    println(strNull?.uppercase())

    //fun <T, R> T.let(block: (T) -> R): R
    strNull?.let {
        it.length
        println(it.length)
        println(it.isEmpty())
        println(it.uppercase())
    }
}