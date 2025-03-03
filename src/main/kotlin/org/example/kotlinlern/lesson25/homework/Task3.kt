package org.example.kotlinlern.lesson25.homework

/*
Задание 3. Создай функцию,
которая принимает список строк и число,
а возвращает список из строк,
длина которых больше или равна заданному числу.
Если список пуст, нужно выкинуть исключение.
По аналогии с предыдущим заданием выполни трансформации и проверки.
 */

fun main() {
    val list: List<String> = listOf()
    val list2: List<String> = listOf("one", "two", "three")
    val numb = 3

    val function31 = fun (list: List<String>, numb: Int): List<String> {
        require(list.isNotEmpty()) {"list is empty"}
        return list.filter { it.length >= numb }
    }

    val function32: (List<String>, Int)-> List<String> = { list, numb->
        val res = list.filter { it.length >= numb }
        require(res.isNotEmpty()) {"list is empty"}
        res
    }

    val function33 = {list: List<String>, numb: Int ->
        val res = list.filter { it.length >= numb }
        require(res.isNotEmpty()) {"list is empty"}
        res
    }

    println(function33(list, numb))
    println(function33(list2, numb))

}

fun function3(list: List<String>, numb: Int): List<String> {
    val res = list.filter { it.length >= numb }
    require(res.isNotEmpty()) {"list is empty"}
    return  res
}