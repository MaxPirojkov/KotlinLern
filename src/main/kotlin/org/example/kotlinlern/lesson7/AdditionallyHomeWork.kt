package org.example.kotlinlern.lesson7

import kotlin.math.sqrt

fun main(){
//    loopWhileUp()
//    loopWhileEven()
//    sumOfNumbersWhile()
//    doWhileDown()
//    factorialWhile()
//    sumOfEvenNumbers()
//    tablThree()
//    doWhilePrintChar()
//    largestNumber()
//    randomNumb()
//    simpleNumbers() не решил
//    arrayRevers()
//    countLoops()
//    rectangle()
//    fibonachiNumbers()
//    stepCount()
//    averageNumb()
//    multiTableOneToFive()
//    sumOfNumb()
//    sumOfEvenOdd()
}

//Вывод чисел от 1 до 10: Напишите программу, которая выводит числа от 1 до 10 с использованием цикла while.
fun loopWhileUp(){
    var count = 1
    while (count <= 10){
        println(count++)
    }
}

//Четные числа до 20: Используя цикл while, выведите все четные числа от 2 до 20.
fun loopWhileEven(){
    var count = 2
    while (count <= 20){
        if (count % 2 == 0){
        println(count++)
        }
        count++
    }
}

//Сумма чисел от 1 до 50: Напишите программу, которая суммирует числа от 1 до 50 с помощью цикла while.
fun sumOfNumbersWhile() {
    count = 1
    sum = 0
    while (count <= 50){
        sum += count++
        println(sum)
    }
}

//Вывод чисел от 10 до 1: Используя цикл do while, выведите числа от 10 до 1.
fun doWhileDown() {
    count = 10
    do {
        println(count--)
    } while (count >= 1)
}

//Факториал числа 5: Напишите программу, которая вычисляет факториал числа 5 с использованием цикла while.
fun factorialWhile() {
    count = 1
    var numb = 1
    var factorial = 5
    while (count <= factorial){
       numb *= count++
    }
}

//Сумма четных чисел до 100: Используя цикл while, найдите сумму всех четных чисел от 2 до 100.
fun sumOfEvenNumbers(){
    count = 2
    var sum = 0
    while (count <= 100){
        if (count % 2 == 0) {
            sum += count++
            println(sum)
        } else
            count++
    }
}

//Таблица умножения на 3: Напишите программу, которая выводит таблицу умножения на 3.
fun tablThree(){
    var multiplier = 3
    for (i in 1..10){
        println(multiplier * i)
    }
}

//Вывод символов до точки: Используя цикл do while, выведите символы строки "Kotlin." по одному до точки.
fun doWhilePrintChar() {
    val str = "Kotlin."
    val strLength = str.length - 1
    count = 0
    do {
        println(str[count])
        count++
    } while (count < strLength)
}

//Наибольшее число из списка: Напишите программу, которая находит наибольшее число
// из заданного списка чисел с использованием цикла while.
//Пример списка: [5, 12, 7, 22, 9]
fun largestNumber(){
    var  list = listOf(1, 3, 9, 6, 7)
    count = 0
    var largeNumb = 0
    while (count < list.size){
        if (list[count] > largeNumb){
            largeNumb = list[count]
            count++
        } else {
            count++
        }
    }
    println(largeNumb)
}

//Генерация чисел до 15: Используя цикл do while, напишите программу, которая генерирует и выводит числа от 1 до 15.
fun randomNumb() {
    count = 0
    val randomValues = (1 until 16).shuffled().toSet()
    do {
        println(randomValues.elementAt(count))
        count++
    }while (count < randomValues.size)
}

//Обратный порядок элементов массива: Создайте массив из 10 элементов
// и выведите его элементы в обратном порядке с помощью цикла while.
fun arrayRevers(){
    val numbers  = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    count = 9

    while (count >= 0){
        println(numbers[count--])
    }
}

//Количество итераций до 100: Напишите программу,
// которая увеличивает счетчик на 1 в цикле while до тех пор,
// пока значение счетчика не достигнет 100. Выведите количество итераций.
fun countLoops(){
    count = 1
    var howManyLoops = 0
    while (count < 100){
        count++
        howManyLoops++
    }
    println(howManyLoops)
}

//Прямоугольник из символов: Используя вложенные циклы while,
//выведите прямоугольник размером 5x3 из символов *.
fun rectangle() {
    var countHoriz = 0
    var countVertic = 0
    val randomValues = ('a' until 'f').shuffled()
    while (countVertic < 3){
        while (countHoriz < 5){
            print("${randomValues[countHoriz]} ")
            countHoriz++
        }
        println()
        countHoriz = 0
        countVertic++
    }
}

//Числа Фибоначчи до 50: Напишите программу, которая выводит все числа Фибоначчи, не превышающие 50,
// с использованием цикла while.
fun fibonachiNumbers(){
    count = 0
    var a = 0
    var b = 1
    var c = 0
    while (count < 4 ){
       c = a + b
        a = c
        b += a
        print("$a, $b, ")
        count++
    }
}

//Счетчик шагов: Создайте программу, которая считает шаги от 0 до 30 с шагом 5, используя цикл while.
fun stepCount() {
    count = 0
    while (count < 30){
            println(count)
            count +=5
    }
}

//Среднее значение фиксированного списка чисел:
// Найдите среднее значение чисел из списка [4, 8, 15, 16, 23, 42] с помощью цикла while.
fun averageNumb(){
    val list = listOf(4, 8, 15, 16, 23, 42)
    count = 0
    var sum = 0
    while (count < list.size){
        sum += list[count]
        count++
    }
    println(sum / list.size)
}

//Таблица умножения с вложенными циклами:
// Используя вложенные циклы do while,
// напишите программу для вывода таблицы умножения от 1 до 5.
fun multiTableOneToFive(){
   var countNumb = 1
   var countMulti = 1
    do {
        do {
            println("$countNumb * $countMulti = ${countNumb * countMulti}")
            countMulti++
        } while (countMulti < 11)
        countNumb++
        countMulti = 1
    } while (countNumb < 6)
}

//Сумма чисел в диапазоне:
// Напишите программу, которая находит сумму чисел от 10 до 30
// с использованием цикла while.
fun sumOfNumb() {
    count = 10
    sum = 0
    while (count <= 30) {
        sum += count
        count++
    }
    println(sum)
}

//Сумма четных и нечетных чисел: Используя цикл while,
// найдите отдельно сумму четных и сумму нечетных чисел от 1 до 20.
fun sumOfEvenOdd(){
    count = 1
    var sumEven = 0
    var sumOdd = 0
    while (count <= 20){
        if (count % 2 == 0){
            sumEven += count
        } else {
            sumOdd += count
        }
        count++
    }
    println("sum of even = $sumEven")
    println("sum of odd = $sumOdd")
}
