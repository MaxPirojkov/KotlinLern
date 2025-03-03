package org.example.kotlinlern.lesson25.homework

/*
Задание 4. Создай функцию,
которая принимает большое число
и возвращает сумму цифр этого числа.
По аналогии с предыдущим заданием выполни трансформации и проверки.
Подсказка: для парсинга строки “3” в число 3 можно использовать “3”.digitToInt()
 */

fun main() {
    val strNumb = "1234567"
    val emptyNumb = ""
    val negativeNumb = "-1"


    val func41 = fun (numb: String): Int {
        require(numb.isNotEmpty()) { "numb is empty" }
        return numb.sumOf { it.digitToInt() }
    }

    val func42 : (String)-> Int = { numb ->
        require(numb.isNotEmpty()) { "numb is empty" }
        numb.sumOf { it.digitToInt() }
    }

    val func43 = {numb: String ->
        require(numb.isNotEmpty()) { "numb is empty" }
        numb.sumOf { it.digitToInt() }
    }

    println(func43(strNumb))
   // println(func42(emptyNumb))
    println(func43(negativeNumb))

}

fun func4(numb: String): Int {
    require(numb.isNotEmpty()) { "numb is empty" }
    return numb.sumOf { it.digitToInt() }
}