package org.example.kotlinlern.lesson25.homework

/*
Задание 6. Создай функцию расширение словаря из строк и чисел,
которая принимает число
и возвращает список ключей,
длина которых меньше их значений
но больше заданного в функции аргумента.
В случае если список получается пустой нужно выкинуть исключение IllegalState.
По аналогии с предыдущим заданием выполни трансформации и проверки.
 */

fun main() {
    val myMap = mapOf("one" to 1, "ones" to 5)

    val function61 = fun Map<String, Int>.(numb: Int): List<String> {
        val result = this.filter {
            it.value > it.key.length
                    &&
                    it.key.length > numb
        }
            .keys.toList()
        check(result.isNotEmpty()) { "list is empty" }
        return result
    }

    val function62: Map<String, Int>.(Int) -> List<String> = { numb: Int ->
        val result = this.filter {
            it.value > it.key.length
                    &&
                    it.key.length > numb
        }
            .keys.toList()
        check(result.isNotEmpty()) { "list is empty" }
        result
    }

    println(myMap.function62(3))
}

fun Map<String, Int>.function6(numb: Int): List<String> {
    val result = this.filter {
        it.value > it.key.length
                &&
                it.key.length > numb
    }
        .keys.toList()
    check(result.isNotEmpty()) { "list is empty" }
    return result
}