package org.example.kotlinlern.lesson24.homeWork

/*
Задание 5.
Создай свой тип исключения в отдельном файле,
наследуемый от RuntimeException
и принимающий ArrayIndexOutOfBoundsException
тип в качестве аргумента.
Напиши код, который спровоцирует выброс ArrayIndexOutOfBoundsException,
перехвати его с помощью try-catch
и в блоке catch выведи сообщение в консоль
и сделай выброс своего типа исключения.
 */

class CheckRuntime(cause: ArrayIndexOutOfBoundsException) : RuntimeException("check index", cause){

}

fun main() {
    val list = listOf(1, 2, 4)
    try {
            println(list[5])
    } catch (e: ArrayIndexOutOfBoundsException) {
        throw CheckRuntime(e)
    }
}