package org.example.kotlinlern.lesson6
fun main() {
    seasonDefinition(20)

    dogAgeInHuman(1)

    chooseTransport(2.0)

    countBonus(200)

    whatType(".doc")

    convertTemperature(20, 'F')

    whatClothes(-31)

    movieAllowed(6)

}


/*
Задание 1: "Определение Сезона"
Контекст: Напишите функцию, которая на основе номера месяца возвращает сезон года.
*/

fun seasonDefinition(monthNumber: Int): String {
   return when (monthNumber) {
        !in 1..12 -> "Неверно указан месяц"
        3, 4, 5 ->
             "Spring"
        6, 7, 8 ->
             "Summer"
        9, 10, 11 ->
             "Autumn"
        else -> "Зима"
    }
}

/*
Задание 2: "Расчет Возраста Питомца"
Контекст: Создайте функцию, которая преобразует возраст собаки в "человеческие" годы.
До 2 лет каждый год собаки равен 10.5 человеческим годам, после - каждый год равен 4 человеческим годам.
*/

fun dogAgeInHuman(age: Int) {
    if (age < 3) {
        println(age * 10.5)
    } else {
        println((age -2) * 4 + 21)
    }
}

/*
Задание 3: "Определение Вида Транспорта"
Контекст: Напишите функцию, которая определяет, какой вид транспорта лучше использовать, исходя из длины маршрута.
Если маршрут до 1 км - "пешком", до 5 км - "велосипед", иначе - "автотранспорт".
*/

fun chooseTransport(distanceInKm: Double ){
    if (distanceInKm <= 1)
        println("on foot")
    else if (distanceInKm <= 5)
        println("bicycle")
    else
        println("automobile transport")
}


/*
Задание 4: "Расчет Бонусных Баллов"
Контекст: Клиенты интернет-магазина получают бонусные баллы за покупки.
Напишите функцию, которая принимает сумму покупки и возвращает количество бонусных баллов:
2 балла за каждые 100 рублей при сумме покупки до 1000 рублей и 5 баллов за каждые 100 рублей при сумме свыше этого.
 */

fun countBonus(purchaseAmount: Int) {
    if (purchaseAmount > 0) {
        val price = purchaseAmount / 100
        val coefic: Int = if (price < 1000) {
            2
        } else {
            5
        }
         when {
            purchaseAmount <= 1_000 -> {
                price * coefic
            }
            else -> price * coefic
        }
    }
}

/*
Задание 5: "Определение Типа Документа"
Контекст: В системе хранения документов каждый файл имеет расширение.
Напишите функцию, которая на основе расширения файла возвращает его тип:
"Текстовый документ", "Изображение", "Таблица" или "Неизвестный тип".
 */

fun whatType(file: String): String{
    return when (file) {
        ".txt", ".doc" -> "Текстовый документ"
        ".tbl" -> "Таблица"
        else -> "Неизвестный тип"
    }
}

/*
Задание 6: "Конвертация Температуры"
Контекст: Создайте функцию, которая конвертирует температуру из градусов Цельсия в Фаренгейты
и наоборот в зависимости от указанной единицы измерения (C/F).
Единицу измерения нужно передать вторым аргументом функции. Несколько аргументов передаются через запятую.
Возвращать нужно строку.
Подсказка: для генерации строки из числа и буквы можно использовать шалон “$result F” для фаренгейта
или “$result C” для цельсия
 */

fun convertTemperature(temperature: Int, typeMeasure: Char): String{
    var result = 0.0
    return if (typeMeasure == 'C') {
        result = temperature * 9 / 5 + 32.0
        "$result F"
    } else if (typeMeasure == 'F') {
        result = (temperature - 32.0) / 9 * 5
        "$result C"
    } else {
        "unknown type"
    }
}

/*
Задание 7: "Подбор Одежды по Погоде"
Контекст: Напишите функцию, которая на основе температуры воздуха рекомендует тип одежды:
"куртка и шапка" при температуре ниже 0, "ветровка" от 0 до 15 градусов и "футболка и шорты"
при температуре выше 15. При температурах ниже -30 и выше +35 рекомендуйте не выходить из дома.
 */

fun whatClothes(temperature: Int){
    when{
        temperature in -29..0-> println("Куртка и шапка")
        temperature in 0..14 -> println("ветровка")
        temperature in 15..35 -> println("футболка и шорты")
        temperature >= 35 || temperature <= -30 -> println("рекомендуется не выходить из дома")
        else -> println("Ошибка ввода")
    }
}

/*
Задание 8: "Выбор Фильма по Возрасту"
Контекст: Кинотеатр предлагает фильмы разных возрастных категорий.
Напишите функцию, которая принимает возраст зрителя и возвращает доступные
для него категории фильмов: "детские", "подростковые", "18+".
 */

fun movieAllowed(age: Int): String{
    return if (age < 7 )
        "детские"
    else if (age < 18)
        "подростковые"
    else "18+"
}