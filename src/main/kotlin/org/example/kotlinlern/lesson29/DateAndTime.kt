package org.example.kotlinlern.lesson29

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

//

fun main() {
    val instant = Instant.now()  //Instant - используется для работы таймстемпов - метки, now() вернет кол-во секунд
    println(instant.toEpochMilli())      //1742242038064   ms

    val dateTimeNow = LocalDate.now()     //LocalDate хранит в себе год, месяц, день
    val birthday = LocalDate.of(1982, 1, 2)

    println(dateTimeNow) //2025-03-17
    println(birthday)    //1982-01-02

    val localTimeNow = LocalTime.now() // часы, минуты. сек, наносек
    val endOfTheMyWorkingDay = LocalTime.of(20, 3, 0, 0)

    val localDateTime = LocalDateTime.now()
    val alarmClock = LocalDateTime.of(2025, 4, 1, 9, 0, 0, 0)

    val vaticanCurrentTime = ZonedDateTime.now(ZoneId.of("Europe/Vatican")) // учитывается регион смещения
    val mobileWorldCongress = ZonedDateTime.of(2025, 2, 22, 10, 2, 0, 0, ZoneId.of("Europe/Vatican"))

    val birthdayInDubai = OffsetDateTime.of(birthday.atTime(19, 0), ZoneOffset.of("+09:00"))
    val vaticanCurrentTimeInstant = vaticanCurrentTime.toInstant()  // преобразуем в сек

    val birthdayInstant = birthday.atTime(19, 0).toInstant(ZoneOffset.of("+09:00"))

    val instantToZoneDateTime =
        instant.atZone(ZoneId.systemDefault())   // systemDefault() вернет часовой пояс установленный на компуктере

    val instantToOffsetDateTime = instant.atOffset(ZoneOffset.of("-02:00")) // atOffset передает смещение времени

    LocalDate.now().plusYears(1)      //добавит один год к текущей дате
    LocalDateTime.now().plusSeconds(1)
    LocalDate.now().minusYears(1)

    Period.between(birthday, LocalDate.now())    //высчитывает разницу между датами года месяцы

    Duration.between(alarmClock, LocalDateTime.now())   // высчитывает разницу в секундах

    alarmClock.isAfter(localDateTime)  // проверяет какая из дат позже - вернет boolean

    alarmClock.isEqual(localDateTime)   // проверяет равенство

    val nextAlarmClock = alarmClock.plus(5, ChronoUnit.MINUTES)   // ChronoUnit указывает что использоваьт при вычитании
    val nextBirthday = birthday.plusYears(1)

    val nanoSeconds = Duration.ofNanos(200)   //Duration хранит длительно  и у него можем вызвать ofNanos
    println(nanoSeconds.dividedBy(4).toNanos())      // разделить на части
    println(nanoSeconds.plus(Duration.ofSeconds(2)).toNanos())
    val seconds = Duration.ofSeconds(45)
    println(seconds.minusMinutes(1).seconds)
    val period = Period.of(2, 4, 10)    // Period не учитывает кол-вл дней в мес
    println(period.minusMonths(13).toTotalMonths())
    val periodFromConferenceToBirthday = Period.between(
        mobileWorldCongress.toLocalDate(),
        birthday
    )   // возвращает отрицательные числа потому что не верно указаны аргументы
    println("${periodFromConferenceToBirthday.years} years ${periodFromConferenceToBirthday.months} months ${periodFromConferenceToBirthday.days}")

    val formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ") //можно использовать для форматирования и для парсинга
    val formattedDate = vaticanCurrentTime.format(formatter)
    println(formattedDate)

    val isoFormatter = DateTimeFormatter.ISO_DATE_TIME       //iso стандарт вывода даты и времени
    val isoFormatterDate = birthdayInDubai.format(isoFormatter)
    println(isoFormatterDate)


    val prettyFormatter = DateTimeFormatter.ofPattern("'year' yyyy', month' MM', day' dd")       //iso стандарт вывода даты и времени
    val prettyFormatterDate = dateTimeNow.format(prettyFormatter)
    println(prettyFormatterDate)

//    try {
//        println(localDateTime.format(formatter))
//    } catch (e: Throwable) {
//        e.printStackTrace()
//    }

    val parsedDate = LocalDate.parse(prettyFormatterDate, prettyFormatter)
    println(parsedDate)

}