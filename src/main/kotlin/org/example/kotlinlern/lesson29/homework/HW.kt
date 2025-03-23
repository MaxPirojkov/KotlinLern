package org.example.kotlinlern.lesson29.homework

import org.w3c.dom.ranges.Range
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal
import kotlin.math.cbrt

fun main() {
    /*
    Создай текущую временную метку и выведи её на печать (чтобы ещё раз запомнить название этого класса)
     */

    val timePoint = Instant.now()
    println(timePoint)


    /*
    Создай дату своего дня рождения.
     */
    val birthday = LocalDate.of(1987, 7, 14)
    val dateToday = LocalDate.of(2025, 3, 19)

    /*
    Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
     */
    println(Period.between(birthday, dateToday).years) //P37Y


    /*
    Task5
    Создай объекты дат и / или времени
    которые мы изучили
    и по очереди передай
    их в метод созданный выше.
    Не используй в них метод now()
     */
    val temporal1: Temporal = LocalDate.of(1980, 2, 12)
    val temporal2: Temporal = LocalTime.of(12, 30, 10)
    val temporal3: Temporal = LocalDateTime.of(1980, 12, 1, 1, 12, 22)
    val temporal4: Temporal = ZonedDateTime.of(1980, 2, 11, 1, 12, 44, 1,  ZoneId.of("Europe/Moscow"))
    val temporal5: Temporal = OffsetDateTime.of(1980, 2, 12, 10, 55, 10, 11, ZoneOffset.of("+09:00"))
    val temporal6: Temporal = Period.of(1000, 10, 12).addTo(temporal1)

    task4(temporal1) // 1980-02-12
    task4(temporal2) // 12:30:10
    task4(temporal3) // 1980-12-01 01:12:22
    task4(temporal4) // 1980-02-11 01:12:44 +0300
    task4(temporal5) // 1980-02-12 10:55:10 +0900
    task4(temporal6) // 2980-12-24

    println("------------")
    task4Iso(temporal1) // 1980-02-12
    task4Iso(temporal2) // 12:30:10
    task4Iso(temporal3) // 1980-12-01 01:12:22
    task4Iso(temporal4) // 1980-02-11T01:12:44.000000001+03:00[Europe/Moscow]
    task4Iso(temporal5) // 1980-02-12T10:55:10.000000011+09:00
    task4Iso(temporal6) // 2980-12-24

    val boomer = LocalDate.of(1946, 1, 10)
    val zoomer = LocalDate.of(2012, 1, 12)
    val noOne = LocalDate.of(1965, 12, 1)
    task6(boomer)
    task6(zoomer)
    task6(noOne)

    val birthday1 = LocalDate.of(2023, 3, 7)
    val birthday2 = LocalDate.of(2024, 3, 6)
    formatter(birthday1)
    formatter(birthday2)
    println( Period.between(birthday1, birthday2))  // P11M28D

}

/*
Task 4
Создай функцию, которая принимает тип Temporal
и выводит форматированное значение в зависимости от того,
содержит ли аргумент время и часовой пояс.
Temporal - это общий тип для разных классов даты-времени.
В форматированном значении нужно выводить часы, минуты, секунды и таймзону,
если они представлены в переданном объекте.
Обработай в методе все типы дат, которые знаешь.
Реализуй два варианта функции -
с собственный форматированием и с форматами из ISO коллекции.
 */

fun task4(date: Temporal) {
    when (date) {
        is LocalDate -> date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        is LocalTime -> DateTimeFormatter.ofPattern("HH:mm:ss").format(date)
        is LocalDateTime -> date.format((DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
        is ZonedDateTime -> date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZ"))
        is OffsetDateTime -> date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZ"))
        else -> date.toString()
    }.also { println(it) }
}

fun task4Iso(date: Temporal) {
    when(date) {
        is LocalDate -> date.format(DateTimeFormatter.ISO_LOCAL_DATE)
        is LocalTime -> date.format(DateTimeFormatter.ISO_LOCAL_TIME)
        is LocalDateTime -> date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        is ZonedDateTime -> date.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
        is OffsetDateTime -> date.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        else -> date.toString()
    }.also { println(it) }
}

/*
task6

Создайте функцию identifyGeneration,
которая принимает дату рождения в формате LocalDate
и печатает строку, определяющую,
к какому поколению принадлежит человек:
"Бумер" для тех, кто родился с 1946 по 1964 год включительно,
и "Зумер" для тех, кто родился с 1997 по 2012 год включительно.
Если дата рождения не попадает ни в один из этих диапазонов,
функция должна возвращать "Не определено".
Для сравнения дат используй методы isAfter(otherDate)
и isBefore(otherDate).
Объекты с эталонными датами вынеси
в приватные поля файла с методом identifyGeneration.
 */
private val boomerFrom = LocalDate.of(1946, 1, 1)
private val boomerEnd = LocalDate.of(1964, 12, 31)
private val zoomerFrom = LocalDate.of(1997, 1, 1)
private val zoomerEnd = LocalDate.of(2012, 12, 31)

fun task6(date: LocalDate) {
    when {
        date.isAfter(boomerFrom) && date.isBefore(boomerEnd) -> "Boomer"
        date.isAfter(zoomerFrom) && date.isBefore(zoomerEnd) -> "Zoomer"
        else -> "Ne opredeleno"
    }.also { println(it) }
}

/*
task 7
Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года.
Создай форматтер, который форматирует дату в месяц и день.
Выведи первую отформатированную дату, прибавив к ней 10 дней.
Выведи вторую отформатированную дату, прибавив к ней 10 дней.
Найди отличия)))
 */

fun formatter(date: LocalDate) {
     println(date.plusDays(10).format(DateTimeFormatter.ofPattern("MM-dd")))
}