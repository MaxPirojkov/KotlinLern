package org.example.kotlinlern.lesson21

/*
Дженерики - позволяют работать с разными типа данными,
они позволяют на этапе кода заявить, что будут хранить определенный тип данных.
например в коллекциях тип в скобках <> это дженерики
 */

class Box<TYPE>(private val item: TYPE) {
    fun getItem(): TYPE {
        return item
    }
}

fun <T> printItem(item: T): T {
    println("Element: $item")
    return item
}

// Тип Number - это общий тип, но только для числовых Значение
fun <T : Number> sum(a: T, b: T): Double {
    return a.toDouble() + b.toDouble()
}


class GenericIterator<T : Number, R : Iterable<T>>(
    private val argument: T, private val elements: R
) {

    fun printElements() {
        for (e in elements) {
            println(
                e.toString().repeat(argument.toInt())
            )
        }
    }
}


fun main() {
    val myBox = Box("Box TYPE")
    println(myBox.getItem())

    printItem("Hello T")
}

//класс ограниченный джинериком, который хранит объект типа Т
class Container<T>(val item: T) {}

// класс который хранит два объекта, как Pair
class PairBox<A, B>(val first: A, val second: B) {}


// А? - можно передавать null
class LimitedContainer<A : Number>(val volume: A?)


//
interface Storage<T> {
    fun set(a: T)

    fun get(): T
}

interface Transformer<A, B> {
    fun convert(volume: A): B
}

fun <A> swap(list: List<A>, index1: Int, index2: Int): List<A> {
    return list
}

fun <A> merg(list1: List<A>, list2: List<A>): List<A> {
    return list1
}

//fun <K, V> toMap(keyList: List<K>, valueList: List<V>): Map<K, V> {
//    return
//}