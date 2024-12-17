package org.example.kotlinlern.lesson10

fun main() {
//    fillArrayDouble()
//    fillArrayInt()
//    arrNull()
//    copyArray()
//    difTwoArrray()
//    searchIndx(5)
//    arrayEvenOdd()
//    val arrayStr = arrayOf("В", "огороде-то", "на", "грядке", "вырастают", "шоколадки")
//    val str = "грядке"
//    searchElement(arrayStr, str)
//    displayList(1, 2 , 3, 4, 5)
//    val listString = listOf("В", "огороде-то", "на", "грядке", "вырастают", "шоколадки")
//    listItemIndex(listString)
//    val mutableListNumb = mutableListOf(1, 2, 3, 4, 5)
//    changeList(mutableListNumb)
    val firstList = listOf("Создайте", "два", "списка", "строк")
    val secondList = listOf("и объедините", "их", "в один", "новый", "список")
//    unionList(firstList, secondList)
    val listNumbers = listOf(11, 3, 2, 5, 6, 1)
//    findMinMaxList(listNumbers)
//    listFilter(listNumbers)
    val setString = setOf("Kotlin", "Java", "Scala")
    val oneWord = "Java"
    val setInt = setOf(1, 2, 3, 4, 5, 10)
//    loopSet(setInt)
//    findStrSet(setString, oneWord)
    val setNum = setOf(1, 2, 3, 4, 5)
    val setNum2 = setOf(2, 5, 7, 8)
//    joinTwoSet(setNum, setNum2) // выведет 1, 2, 3, 4, 5, 7, 8
//    commonElementsSet(setNum, setNum2) // выведет 2, 5
//    difSets(setNum, setNum)
    convertSetToList(setString)
}

//Работа с массивами Array
//Задание 1: Создание и Инициализация Массива
//Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
val arrayInt = arrayOf(1, 2, 3, 4, 5)

//Задание 2: Создание Пустого Массива
//Создайте пустой массив строк размером 10 элементов.
val emptyArray = Array(10) { " " }

//Задание 3: Заполнение Массива в Цикле
//Создайте массив из 5 элементов типа Double
//и заполните его значениями, являющимися удвоенным индексом элемента.
fun fillArrayDouble() {
    val arrayDouble = DoubleArray(5) { 0.0 }
    for (i in arrayDouble.indices) {
        arrayDouble[i] = (i * i).toDouble()
    }
}

//Задание 4: Изменение Элементов Массива
//Создайте массив из 5 элементов типа Int.
// Используйте цикл, чтобы присвоить каждому элементу значение,
// равное его индексу, умноженному на 3.
fun fillArrayInt() {
    val arrayInt = Array(5) { 0 }
    val multiplier = 3
    for (i in arrayInt.indices) {
        arrayInt[i] = i * multiplier
    }
}

//Задание 5: Работа с Nullable Элементами
//Создайте массив из 3 nullable строк.
//Инициализируйте его одним null значением и двумя строками.
fun arrNull() {
    val nullArray: Array<String?> = arrayOfNulls(3)
    val str = "value"
    for (i in nullArray.indices) {
        if (i == 0) {
            nullArray[i] = null
        } else {
            nullArray[i] = str
        }
    }
}

//
//Задание 6: Копирование Массива
//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
fun copyArray() {
    val arrayFilled = arrayOf(1, 2, 3, 4, 5)
    val arrayEmpty = Array(5) { 0 }
    for (i in arrayFilled.indices) {
        arrayEmpty[i] = arrayFilled[i]
    }
    println(arrayEmpty.toList())
}

//Задание 7: Разница Двух Массивов
//Создайте два массива целых чисел одинаковой длины.
//Создайте третий массив, вычев значения одного из другого.
fun difTwoArrray() {
    val firstArray = arrayOf(1, 3, 2, 4, 5)
    val secondArray = arrayOf(5, 6, 7, 9, 8)
    val emptyArray1 = Array(5) { 0 }
    for (i in emptyArray1.indices) {
        emptyArray1[i] = secondArray[i] - firstArray[i]
    }
    println(emptyArray1.toList())
}

//Задание 8: Поиск Индекса Элемента
//Создайте массив целых чисел. Найдите индекс элемента со значением 5.
//Если значения 5 нет в массиве, возвращаем -1. Реши задачу через цикл while.
fun searchIndx(value: Int) {
    var count = 0
    val arrayNumb = arrayOf(1, 2, 4, 5, 6, 3)
    var index = 0
    while (count <= arrayNumb.last()) {
        if (arrayNumb[count] == value) {
            index = count
            count++
        }
        count++
    }
    if (index != 0) {
        println("Значение $value по индексу $index ")
    } else {
        println("-1")
    }
}

/*
Задание 9: Перебор Массива
Создайте массив целых чисел.
Используйте цикл для перебора массива и вывода каждого элемента в консоль.
Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
 */
fun arrayEvenOdd() {
    val arrayInt = arrayOf(1, 3, 4, 5, 2, 6, 7, 8, 9, 10)
    for (i in arrayInt.indices) {
        if (arrayInt[i] % 2 == 0) {
            println("${arrayInt[i]} - четное")
        } else {
            println("${arrayInt[i]} - нечетное")
        }
    }
}

/*
Задание 10: Поиск Значения в Массиве по вхождению
Создай функцию, которая принимает массив строк и строку для поиска.
Функция должна находить в массиве элемент,
в котором принятая строка является подстрокой (метод contains()).
Верни найденный элемент из функции в виде строки.
 */
fun searchElement(array: Array<String>, str: String) {
    for (i in array) {
        if (i.contains(str)) {
            println("$i")
        } else {
            println("строка не найдена")
        }
    }
}

/*
Работа со списками List
Задание 1: Создание Пустого Списка
Создайте пустой неизменяемый список целых чисел.
 */
val list = List(5) { 0 }

/*
Задание 2: Создание и Инициализация Списка
Создайте неизменяемый список строк,
содержащий три элемента (например, "Hello", "World", "Kotlin").
 */
val listStr = listOf("Hello", "World", "Kotlin")

/*
Задание 3: Создание Изменяемого Списка
Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
 */
val mutableList = mutableListOf(1, 2, 3, 4, 5)

/*
Задание 4: Добавление Элементов в Список
Имея изменяемый список целых чисел,
добавьте в него новые элементы (например, 6, 7, 8).
*/
fun addItems() {
    val mutableList = mutableListOf(1, 2, 3, 4, 5)
    mutableList.add(6)
    mutableList.add(7)
    mutableList.add(8)
}

/*
Задание 5: Удаление Элементов из Списка
Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
*/
fun removeItemList() {
    val mutableList = mutableListOf("Hello", "World", "Kotlin")
    mutableList.remove("World")
}

/*
Задание 6: Перебор Списка в Цикле
Создайте список целых чисел и
используйте цикл для вывода каждого элемента на экран.
*/
fun displayList(list: List<Int>) {
    for (i in list) {
        println(i)
    }
}

/*
Задание 7: Получение Элементов Списка по Индексу
Создайте список строк и получите из него второй элемент, используя его индекс.
*/
fun listItemIndex(list: List<String>) {
    println(list[1])
}

/*
Задание 8: Перезапись Элементов Списка по Индексу
Имея изменяемый список чисел, измените значение элемента на определенной позиции
(например, замените элемент на позиции 2 на новое значение).
*/
fun changeList(listNumb: MutableList<Int>) {
    listNumb[1] = listNumb[1] * 1000
    println(listNumb)
}

/*
Задание 9: Объединение Двух Списков
Создайте два списка строк и объедините их в один новый список,
содержащий элементы обоих списков. Реши задачу с помощью циклов.
*/
fun unionList(list: List<String>, list2: List<String>) {
    val thirdList = mutableListOf<String>()
    for (i in list) {
        thirdList.add(i)
    }
    for (i in list2) {
        thirdList.add(i)
    }
    println(thirdList)
}

/*
Задание 10: Нахождение Минимального/Максимального Элемента
Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
*/
fun findMinMaxList(list: List<Int>) {
    var minNumb = 1
    var maxNumb = 1
    for (i in list) {
        if (i > maxNumb) {
            maxNumb = i
        } else if (i < minNumb) {
            minNumb = i
        }
    }
    println("$maxNumb - наибольшее число в списке, $minNumb - наименьшее число в списке")
}

/*
Задание 11: Фильтрация Списка
Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
*/
fun listFilter(list: List<Int>) {
    val evenNumbList = mutableListOf<Int>()
    for (i in list) {
        if (i % 2 == 0) {
            evenNumbList.add(i)
        }
    }
    println(evenNumbList)
}

/*
Работа с Множествами Set
Задание 1: Создание Пустого Множества
Создайте пустое неизменяемое множество целых чисел.
*/
val emptySet = setOf<Int>()

/*
Задание 2: Создание и Инициализация Множества
Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
*/
val setInt = setOf(1, 2, 3)

/*
Задание 3: Создание Изменяемого Множества
Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
*/
val mutableSet = mutableSetOf("Kotlin", "Java", "Scala")

/*
Задание 4: Добавление Элементов в Множество
Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
*/
fun addStringSet() {
    val set1 = mutableSetOf("Kotlin", "Java", "Scala")
    set1 += "Swift"
    set1 += "Go"
}

/*
Задание 5: Удаление Элементов из Множества
Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
*/
fun removeStringSet() {
    val set1 = mutableSetOf("Kotlin", "Java", "Scala", "Swift", "Go")
    set1 -= "Swift"
    set1 -= "Go"
}

/*
Задание 6: Перебор Множества в Цикле
Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
*/
fun loopSet(set: Set<Int>) {
    for (i in set) {
        println(i)
    }
}

/*
Задание 7: Проверка Наличия Элемента в Множестве
Создай функцию, которая принимает множество строк (set) и
строку и проверяет, есть ли в множестве указанная строка.
Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
*/
fun findStrSet(setOfString: Set<String>, str: String): Boolean {
    for (i in setOfString) {
        if (i == str) {
            return true
        }
    }
    return false
}

/*
Задание 8: Объединение Двух Множеств
Создайте два множества строк и объедините их в одно новое множество,
содержащее все уникальные элементы обоих множеств. Реши задачу с помощью циклов.
*/
fun joinTwoSet(set1: Set<Int>, set2: Set<Int>) {
    val set3 = mutableSetOf<Int>()
    for (i in set1) {
        set3 += i
    }
    println(set3)
    for (i in set2) {
        set3 += i
    }
    println(set3)
}

/*
Задание 9: Нахождение Пересечения Множеств
Создайте два множества целых чисел и найдите их пересечение (общие элементы). Реши задачу через вложенные циклы.
*/
fun commonElementsSet(set: Set<Int>, set2: Set<Int>) {
    for (i in set) {
        for (j in set2) {
            if (i == j) {
                println(i)
            }
        }
    }
}

/*
Задание 10: Нахождение Разности Множеств
Создайте два множества строк и найдите разность первого множества относительно второго
(элементы, присутствующие в первом множестве, но отсутствующие во втором).
Реши задачу через вложенные циклы и переменные флаги.
*/
fun difSets(set: Set<Int>, set2: Set<Int>) {
    for (i in set) {
        for (j in set2) {
            if (i != j) {
                println("$i - $j = ${i - j}")
            }
        }
    }
}

/*
Задание 11: Конвертация Множества в Список
Создайте множество строк и конвертируйте его в список с использованием цикла.
 */
fun convertSetToList(set: Set<String>) {
    val list = mutableListOf<String>()
    for (i in set){
        list += i
    }
    println(list)
}