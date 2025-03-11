package org.example.kotlinlern.lesson27

import java.io.File

// Scope функции
// набор расширений для произвольных классов, которые позволяют сделать код кратким и более читаемым
// эти функции позволяют выполнять блок кода в контексте объекта - без этого объекта

fun main() {
    val list = mutableListOf(1, 2, 3)

    println(list.size)
    list.add(3)
    println(list.size)

    val l: MutableList<Int>.() -> Unit = {
        println(size)
        add(4)
        println(size)
    }

    with(list) {                //with{} функция существует сама по себе
        println(size)
        add(4)
        println(size)
    }

    list.add(6)
    val result = list.sum()

    //run{} функция вызывается из контекста (в лямбда) В отличие от apply, возвращает не сам объект, а то, что указано в блоке.
    val result2 = list.run {
        add(5)
        sum()
    }

    // use{} функция позволяет работать с потоками
    val s = File("example.txt").inputStream().use {
        val content = it.readBytes()
        println(content.size)
    }
    /* apply {} используют для инициализации сложного объекта. ничего не возвращает
    apply — это функция-расширение которая:
    Выполняет блок кода на объекте (в контексте this).
    Возвращает сам объект после выполнения блока.
    Используется для инициализации или настройки свойств объекта. */

    val list2 = mutableListOf<Int>().apply {
        add(1)
        add(2)
    }

    // не меняет тип данных. что принял то и вернул
    list.also {
        println("add 3 к списку $it")
    }.add(3)

    //let{}
    val srt: String? = null
    srt?.let {
        println(it.length)  // выполнится только если srt не null
    } ?: println("is null")




}

