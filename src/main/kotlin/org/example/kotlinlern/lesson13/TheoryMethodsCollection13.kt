package org.example.kotlinlern.lesson13

val list = listOf(8, 56, 2, 12, 87)

fun filter(collection: List<Int>): List<Int> {
    val res = mutableListOf<Int>()
    for (i in collection) {
        if (i in 7..17 ) res.add(i)
    }
    return res
}

val filter2 = list.filter { it in 7..17 } // тоже самое что и в функции выше filter()