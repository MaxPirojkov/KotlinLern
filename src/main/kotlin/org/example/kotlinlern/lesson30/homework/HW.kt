package org.example.kotlinlern.lesson30.homework

import org.example.kotlinlern.lesson30.HasValue
import java.time.Duration
import kotlin.Exception
import kotlin.concurrent.thread

fun main() {
    //   printRealEstate()
    //   task3 { println("Success") }
    //   println( task3 { throw AssertionError("Test") })
    //   println( task3 { throw Exception() } )
    //   println(task4 { it.distanceAE > 10 }) // URAN
    //   task4 { it.distanceAE > 40 }   //Exception
}

/*
Задание 1
Создай Enum со статусами прохождения теста (pass, broken, failure).
Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.
Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.
*/

enum class TestStatus {
    PASS,
    BROKEN,
    FAILURE
}

enum class RealEstateType(val type: String) {
    APARTMENT("Квартира"),
    HOUSE("Частный жилой дом"),
    OFFICE("Офисная недвижимость"),
    WAREHOUSE("Складская недвижимость"),
    HOTEL("Гостиничная недвижимость"),
    COMMERCIAL("Торговая недвижимость"),
    ;
}

enum class SunSystem(val weight: String, val distanceAE: Double) {
    MERCURY("3.30 x 10^23", 0.39),
    Venus("4.87 x 10^24", 0.72),
    EARTH("4.87 x 10^24", 1.00),
    MARS("6.42 x 10^23", 1.52),
    JUPITER("1.90 x 10^27", 5.20),
    SATURN("5.68 x 10^28", 9.59),
    URAN("8.68 x 10^25", 19.22),
    NEPTUNE("1.02 x 10^28", 30.05)
}

/*
Задание 2
Создай функцию,
которая выводит на печать
человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.
 */
fun printRealEstate() {
    RealEstateType.entries
        .sortedBy { it.name.length }
        .forEach { println(it.type) }
}

/*
Задание 3
Создай функцию,
которая принимает лямбду без аргументов
и возвращаемого значения
и возвращает Enum со статусом прохождения теста
в зависимости от того как выполнится принятая лямбда.
Если без исключений - pass, если будет AssertionError - failure, прочие исключения  - broken.
*/

fun task3(arg: () -> Unit): TestStatus {
    try {
        arg()
    } catch (e: AssertionError) {
        return TestStatus.FAILURE
    } catch (e: Exception) {
        return TestStatus.BROKEN
    }
    return TestStatus.PASS

}

/*
Задание 4
Создай функцию,
которая принимает лямбду
и возвращает enum планеты.
Лямбда должна принимать планету
и возвращать булево значение.
Лямбда здесь выступает
в качестве фильтра,
который должен отфильтровать список всех планет по какому-либо признаку
(расстояние или вес).
Вернуть нужно первый элемент из отфильтрованного списка
или выкинуть исключение если список пустой.
 */

fun task4(arg: (SunSystem) -> Boolean): SunSystem {
    return SunSystem.entries.firstOrNull { arg(it) } ?: throw java.lang.IllegalStateException()
}