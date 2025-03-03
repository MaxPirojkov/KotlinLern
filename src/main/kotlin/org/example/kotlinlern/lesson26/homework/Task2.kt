package org.example.kotlinlern.lesson26.homework

/*
Задания на разработку кода

⚡ Для последних четырёх заданий сделать минимум по две разные реализации лямбда функций и проверить работу на разных наборах данных
 */

//Напишите функцию filterStrings,
// которая принимает список строк и функцию-фильтр,
// оставляющую только строки,
// удовлетворяющие условию
// (то-есть принимающая строку и возвращающая булево значение).
// Функция должна вернуть результат фильтрации исходного списка строк.
fun filterStrings(list: List<String>, stringFilter: (String) -> Boolean): List<String> {
    return list.filter(stringFilter)
}

//Создайте функцию applyToNumbers,
// которая принимает список чисел и функцию,
// преобразующую каждое число в другое число
// (те-есть принимающая число и возвращающая число).
// Функция должна вернуть результат преобразования исходного списка чисел.
fun applyToNumbers(list: List<Int>, intConvert: (Int) -> Int): List<Int> {
    return list.map(intConvert)
}

//Реализуйте функцию sumByCondition,
// которая принимает список чисел и функцию,
// определяющую условие для включения числа в сумму.
// Функция должна вернуть сумму чисел, прошедших проверку.
fun sumByCondition(list: List<Int>, condition: (Int) -> Boolean): Int {
    return list.filter(condition).sum()
}

//Напишите функцию combineAndTransform,
// которая принимает две коллекции одного типа
// и функцию для их объединения и преобразования в одну коллекцию другого типа.
// Функция должна вернуть результат преобразования (коллекцию второго типа)
fun combineAndTransform(
    collection1: List<Int>,
    collection2: List<Int>,
    funcContain: (List<Int>, List<Int>) -> List<String>,
): List<String> {
    return funcContain(collection1, collection2)
}


fun main() {

    //1
    val myListString = listOf("one", "two", "three")
    val myListString2 = listOf("1", "", "three")
    val filterStr = filterStrings(myListString) { it.length < 2 }
    val filterStr2 = filterStrings(myListString2) { it.isNotEmpty() }

    println(filterStr2)

    //2
    val myListInt = listOf(-1, 2, 3, 4, 0)
    val applyToNumb = applyToNumbers(myListInt) { it + 5 }
    val applyToNumb2 = applyToNumbers(myListInt) { 10 - it }

    println(applyToNumb2)

    //3
    val sumOfNumber = sumByCondition(myListInt) { it > 0 }
    val sumOfNumber2 = sumByCondition(myListInt) { it != 0 }
    println(sumOfNumber2)

    //4
    val myListInt1 = listOf(1, 2, 3)
    val myListInt2 = listOf(4, 5, 6)
    val combine = combineAndTransform(myListInt1, myListInt2) { list1, list2 -> (list1 + list2).map { it.toString() } }
    val combine2 = combineAndTransform(myListInt1, myListInt2) {  list1, list2 -> (list1 + list2).map { "$it number of list " } }

    println(combine2)
}