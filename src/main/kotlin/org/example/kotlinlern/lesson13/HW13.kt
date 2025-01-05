package org.example.kotlinlern.lesson13

import org.example.kotlinlern.lesson12.isEven

fun main() {
    val list = listOf(0, 2, 3, 4, 5, 6, 25)
    val listPi = listOf(1, 3, 14, 5, 8)
    val emptyList: List<Int> = listOf()
    val shortList = listOf(1, 2, 3, 4)
    val bigList = listOf(4000, 5000, 1001, 3000, 2050)
    val biglst2 = listOf(1050, 1200, 1001, 1201, 1300)
    val avarageList = listOf(10, 10, 10, 10, 10, 10, 10, 10, 10, 10)
    val list2 = listOf(5, 6, 7, 8, 5)
    val strList = listOf("one", "two", "three", "four")
    val strlistJoin = listOf(1, 2, 2, 4, 5, 6, 7, 8, 9, 10)
    val minNumber = listOf(-19, -18, -10, -12, -13)
    val uniqList = listOf(-10, -9, -6, -5, -4, -2)
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    val listOfFurniture = listOf(
        "Стол",
        "табурет",
        "ваза",
        "Кружка",
        "Зеркало",
        "ковер",
        "Шкаф",
        "часы",
        "Люстра",
        "подушка",
        "Картина",
        "столик",
        "Вазон",
        "шторы",
        "Пуф",
        "книга",
        "Фоторамка",
        "светильник",
        "Коврик",
        "вешалка",
        "Подставка",
        "телевизор",
        "Комод",
        "полка",
        "Абажур",
        "диван",
        "Кресло",
        "занавеска",
        "Бра",
        "пепельница",
        "Глобус",
        "статуэтка",
        "Поднос",
        "фигурка",
        "Ключница",
        "плед",
        "Тумба",
        "игрушка",
        "Настенные часы",
        "подсвечник",
        "Журнальный столик",
        "сувенир",
        "Корзина для белья",
        "посуда",
        "Настольная лампа",
        "торшер",
        "Этажерка"
    )
    val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    val ages = listOf(2, 18, 30, 45, 17, null, 60)
    searchAge(ages)
//    categoryNumb(numbers)
//    averageLength(listOfFurniture)
//    catalogList(listOfFurniture)
//    analizMarks(grades)
//    getElement(list)
//    collectionToString(list)
//    sumList(list)®
//    avarageList(list2)
//    maxNumberList(list)®
//    minNumberList(list)
//    firstNumb(list)
//    containsList(list)
//    filterList(list)
//    numDevyy(list)
//    stringList(strList)
//    txtList(strList)
//    mapStrList(strList)
//    sortList(strList)
//    sortDownList(list2)
//    squareElementList(list)
//    firstLetter(strList)
//    clearDuble(list2)
//    firstThreeElement(list)
//    checkCollection(emptyList)
//    checkCollection(shortList)
//    checkCollection(list)
//    checkCollection(bigList)
//    checkCollection(avarageList)
//    checkCollection(strlistJoin)
//    checkCollection(minNumber)
//    checkCollection(biglst2)
//    checkCollection(listPi)
//    checkCollection(uniqList)

}

/*
Подбери подходящий для задачи метод
Задачи на приведение коллекций к значению
isNotEmpty
getOrElse
joinToString
firstOrNull
size
isEmpty
minOrNull
contains
sum
average
maxOrNull

Проверить, что размер коллекции больше 5 элементов.
 */
fun sizeCollection(list: List<Int>) {
    if (list.size > 5) println("List size > 5")
}

/*
Проверить, что коллекция пустая
*/
fun emptyCollection(list: List<Int>) {
    list.isEmpty()
}

/*
Проверить, что коллекция не пустая
*/
fun isNotEmpty(list: List<Int>) {
    list.isNotEmpty()
}

/*
Взять элемент по индексу или создать значение если индекса не существует
*/
fun getElement(list: List<Int>) {
    list.getOrElse(1) { -100 }
}

/*
Собрать коллекцию в строку
*/
fun collectionToString(list: List<Int>) {
    list.joinToString("-/-")
}

/*
Посчитать сумму всех значений
*/
fun sumList(list: List<Int>) {
    list.sum()
}

/*
Посчитать среднее
*/
fun avarageList(list: List<Int>) {
    list.average()
}

/*
Взять максимальное число
*/
fun maxNumberList(list: List<Int>) {
    println(list.maxOrNull())
}

/*
Взять минимальное число
*/
fun minNumberList(list: List<Int>) {
    list.minOrNull()
}

/*
Взять первое число или null
*/
fun firstNumb(list: List<Int>) {
    println(list.firstOrNull())
}

/*
Проверить что коллекция содержит элемент
 */
fun containsList(list: List<Int>) {
    println(list.contains(100))
}

/*
Задачи на обработку коллекций
sorted +
groupBy
distinct
take
takeLast
filter +
filterNot +
map +
associate +
sortedDescending +
forEach
filterNotNull +

Отфильтровать коллекцию по диапазону 18-30
*/
fun filterList(list: List<Int>) {
    list.filter { it in 18..30 }
}

/*
Выбрать числа, которые не делятся на 2 и 3 одновременно ????
*/
fun numDevyy(list: List<Int>) {
    list.filterNot { it % 2 == 0 && it % 3 == 0 }
}

/*
Очистить текстовую коллекцию от null элементов
*/
fun stringList(list: List<String?>) {
    println(list.filterNotNull())
}

/*
Преобразовать текстовую коллекцию в коллекцию длин слов
*/
fun txtList(list: List<String>) {
    println(list.map { it.length })
}

/*
Преобразовать текстовую коллекцию в мапу, где ключи - слова, а значения - перевёрнутые слова
*/
fun mapStrList(list: List<String>) {
    list.associate { it to it.reversed() }
}

/*
Отсортировать список в алфавитном порядке
*/
fun sortList(list: List<String>) {
    list.sorted()
}

/*
Отсортировать список по убыванию
*/
fun sortDownList(list: List<Int>) {
    list.sortedDescending()
}

/*

Распечатать квадраты элементов списка
*/
fun squareElementList(list: List<Int>) {
    list.forEach { println(it * it) }
}

/*
Группировать список по первой букве слов
*/
fun firstLetter(list: List<String>) {
    list.groupBy { it.first() }
}

/*
Очистить список от дублей
*/
fun clearDuble(list: List<Int>) {
    list.distinct()
}

/*
Взять первые 3 элемента списка
*/
fun firstThreeElement(list: List<Int>) {
    println(list.take(3))
}

/*
Взять последние 3 элемента списка
    list.takeLast(3)
*/


/*
Задание 2: Характеристика числовой коллекции
Написать метод, который принимает коллекцию чисел
и возвращает строку с текущим состоянием коллекции используя конструкцию when
Если коллекция пустая - “Пусто”
Если количество элементов меньше пяти - “Короткая”
Если коллекция начинается с 0 - “Стартовая”
Если сумма всех чисел больше 10000 - “Массивная”
Если среднее значение равно 10 - “Сбалансированная”
Если длина строки образованная склеиванием коллекции в строку равна 20 - “Клейкая”
Если максимальное число меньше -10 - “Отрицательная” ???
Если минимальное число больше 1000 - “Положительная”
Если содержит одновременно числа 3 и 14 - “Пи***тая”
Иначе - “Уникальная”
Вызвать метод с данными, подходящими под каждую из веток
 */
fun checkCollection(list: List<Int>): String {
    return when {
        list.isEmpty() -> "Пусто"
        list.size < 5 -> "Короткая"
        list.firstOrNull() == 0 -> "Стартовая"
        list.sum() > 10_000 -> "Массивная"
        list.average().toInt() == 10 -> "Сбалансированная"
        list.joinToString(",").length == 20 -> "Клейкая"
        list.max() <= -10 -> "Отрицательная"
        list.min() > 1_000 -> "Положительная"
        list.containsAll(listOf(3, 14)) -> "Пи***тая"
        else -> "Уникальная"
    }
}

/*
Задание 3: Анализ Учебных Оценок
Начальные значения:
val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
Цель: Отфильтровать удовлетворительные оценки (>=60),
отсортировать оставшиеся по возрастанию и взять первые 3.
 */
fun analizMarks(list: List<Int>) {
    list.filter { it >= 60 }
        .sorted()
        .take(3)
}

/*
Задание 4: Создание каталога по первой букве.
Начальные значения: val list = listOf(
    "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
)
Цель: Привести все слова в списке к нижнему регистру, сгруппировать в каталог по первой букве.
*/
fun catalogList(list: List<String>) {
    list.map { it.lowercase() }.groupBy { it.first() }
}

/*
Задание 5: Подсчёт средней длины слов в списке.
Начальные значения из задачи 3.
Цель: Перевести все слова в количество букв, подсчитать среднее значение.
Вывести форматированный текст с двумя знаками после запятой.
 */
fun averageLength(list: List<String>) {
    println(String.format("%.2f", list.map { it.length }.average()))
}
/*
Задание 6: Категоризация чисел.
Начальные значения: val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
Цель: Отобрать уникальные числа, отсортировать по убыванию и сгруппировать по четности (“четные” и “нечетные”).
*/

fun categoryNumb(list: List<Int>) {
    println(list.distinct().sortedDescending().groupBy { if (it % 2 == 0) "четные" else "нечетные" })

}

/*
Задание 7: Поиск первого подходящего элемента
Начальные значения: val ages = listOf(22, 18, 30, 45, 17, null, 60)
Цель: Найти первый возраст в списке, который соответствует условию (больше 18),
преобразовать его к строке, или вернуть сообщение "Подходящий возраст не найден".
*/
fun searchAge(list: List<Int?>) {
    println(list.filterNotNull()
        .firstOrNull { it > 18 }
        ?.toString() ?: "Подходящий возраст не найден")
}