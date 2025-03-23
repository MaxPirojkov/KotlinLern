package org.example.kotlinlern.lesson29

import java.time.*

fun main() {
    val currentTime = Instant.now()
    println(currentTime)

    val myTime = Instant.ofEpochSecond(10000)
    println(myTime)

    val dayOne = LocalDate.of(2024, 9, 1)
    val dayTwo = LocalDate.of(2025, 5, 4)
    val diffDay = Period.between(dayOne, dayTwo)
    println(diffDay) // P8M30D

    val dayThree = Period.of(2, 4, 430)
    println(dayTwo.plus(dayThree))

    val calendar = ZonedDateTime.of(2024, 12, 16, 10, 0, 0, 0, ZoneId.of("Europe/Moscow"))
    println(calendar)

    println(dayThree.multipliedBy(2))
}


