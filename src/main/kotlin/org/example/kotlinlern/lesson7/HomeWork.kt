package org.example.kotlinlern.lesson7

fun main() {
//    loopUp()
//    loopUpEven()
//    loopDown()
//    loopDownReduce2()
//    loopStepTwo()
//    loopStepThree()
//    loopUntil()
//    loopUntilFromThree()
//    loopWhileSquare()
//    loopWhealDecrease()
//    loopDoWhile()
//    loopDoWhileUp()
//    loopForBreakOnSix()
//    loopWhileBreakInfin()
//    loopForContinueEven()
//    loopWhileContinueOdd()
//    loopInLoop()
}

/*
Прямой Диапазон:
Напишите цикл for, который выводит числа от 1 до 5.
Напишите цикл for, который выводит четные числа от 1 до 10.
 */

fun loopUp(){
    for(i in 1 .. 5){
        println(i)
    }
}

fun loopUpEven(){
    for(i in 1 .. 10){
        if (i % 2 == 0){
            println(i)
        }
    }
}

/*
Обратный Диапазон:
Создайте цикл for, который выводит числа от 5 до 1.
Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
 */

fun loopDown() {
    for (i in 5 downTo 1){
        println(i)
    }
}

fun loopDownReduce2() {
    for (i in 10 downTo 1){
        println(i-2)
    }
}

/*
С Шагом (step):
Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
 */

fun loopStepTwo() {
    for (i in 1..9 step 2){
        println(i)
    }
}

fun loopStepThree() {
    for (i in 1..20 step 3) {
        println(i)
    }
}

/*
Использование До (until):
Используйте цикл for и until, чтобы вывести числа из диапазона 1-9 (9 не включается).
Напишите цикл for с until, чтобы вывести числа от 3 до 15, не включая 15.
 */

fun loopUntil(){
    for(i in 1 until 9){
        println(i)
    }
}

fun loopUntilFromThree() {
    for (i in 3 until 15) {
        println(i)
    }
}

    /*
    Задания для Цикла while
Цикл while:

Создайте цикл while, который выводит квадраты чисел от 1 до 5.
Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
     */
var count = 1
var sum = 1
    fun loopWhileSquare(){
        while (count++ <= 5){
            println(count * count)
        }
    }

fun loopWhealDecrease(){
    count = 10
    while (count-- >= 5) {
        println(count)
    }

}

/*
Цикл do...while:
Используйте цикл do...while, чтобы вывести числа от 5 до 1.
Создайте цикл do...while, который повторяется, пока счетчик меньше 10, начиная с 5.
 */
fun loopDoWhile(){
    count = 5
    do {
        println(count--)
    } while (count >= 1)
}

fun loopDoWhileUp(){
    count = 5
    do {
        println(count++)
    } while (count < 10)
}

/*
Задания для Прерывания и Пропуска Итерации
Использование break:

Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.

Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.
*/

fun loopForBreakOnSix() {
    for (i in 1..10){
        if (i == 6)
            break
    }
}

fun loopWhileBreakInfin() {
    count = 1
    while (true){
        println(count++)
        if(count == 10)
            break
    }
}

/*
Использование continue:

В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
 */
fun loopForContinueEven(){
    for (i in 1..10){
        if (i % 2 == 0) continue
        println(i)
    }
}
fun loopWhileContinueOdd() {
    count = 1
    while (count <= 10){
        if (count % 3 == 0) {
            count++
            continue
        } else {
            println(count++)
        }
    }
}

/*
Задача на вложенный цикл
Создать цикл в цикле, в каждом использовать диапазон от 1 до 10.
В консоль вывести результат умножения переменных цикла.
Результат умножения выводить через print() и добавлять ещё один print(“ ”) с пробелом,
чтобы отделять значения в строку.
После вложенного цикла выводить пустой println() чтобы следующий проход начинать с новой строки.
Результат должен быть как на картинке.
 */
fun loopInLoop(){
    for(i in 1..10){
        for(j in 1..10){
            print(i * j)
            print(" ")
        }
        println()
    }
}



