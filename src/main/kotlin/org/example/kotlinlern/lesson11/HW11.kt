package org.example.kotlinlern.lesson11

fun main() {
    val mutableMap = mutableMapOf<Int, String>()

//    addPairsToMap()
//    getValueMap()
//    deleteValueMap()
//    mapLoop()
//    changeValueMap()
//    twoMap()
//    mapStringList()
//    mapIntSet()
    searchElemenMap()
}

/*
Задание 1: Создание Пустого Словаря
Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
*/
val emptyMap = mapOf<Int, Int>()

/*
Задание 2: Создание и Инициализация Словаря
Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
*/
val floatDoubleMap = mapOf(1.5F to 2.3, 1.6F to 2.7)

/*
Задание 3: Создание Изменяемого Словаря
Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
*/
val mutableMap = mutableMapOf<Int, String>()

/*
Задание 4: Добавление Элементов в Словарь
Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
 */
fun addPairsToMap() {
    mutableMap[1] = "One"
    mutableMap[2] = "Two"
    println(mutableMap)
}

/*
Задание 5: Получение Значений из Словаря
Используя словарь из предыдущего задания,
извлеките значение, используя ключ.
Попробуй получить значение с ключом, которого в словаре нет.
 */
fun getValueMap() {
    println(mutableMap[1]) // распечатает One
    println(mutableMap[3]) // распечатает null
}

/*
Задание 6: Удаление Элементов из Словаря
Удалите определенный элемент из изменяемого словаря по его ключу.
*/
fun deleteValueMap() {
    mutableMap.remove(1)
    println(mutableMap) // вывод {2=Two}
}

/*
Задание 7: Перебор Словаря в Цикле
Создайте словарь (ключи Double, значения Int)
и выведи в цикле результат деления ключа на значение.
Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
*/
fun mapLoop() {
    val map = mapOf(1.5 to 2, 2.3 to 4, 2.5 to 5, 1.3 to 0)

    for (i in map) {
        if (i.value == 0) {
            println("бесконечность")
        } else {
            println(i.key / i.value)
        }
    }
}

/*
Задание 8: Перезапись Элементов Словаря
Измените значение для существующего ключа в изменяемом словаре.
*/
fun changeValueMap() {
    val changeMap = mutableMapOf(
        1 to "One",
        2 to "Two",
        3 to "Three"
    )
    changeMap[1] = "Один"
    println(changeMap)
}

/*
Задание 9: Сложение Двух Словарей
Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
*/
fun twoMap() {
    val firstMap = mapOf(1 to "One", 2 to "Two", 3 to "Three")
    val second = mapOf(4 to "Four", 5 to "Five")
    val third = mutableMapOf<Int, String>()
    for (i in firstMap) {
        third[i.key] = i.value
    }
    for (i in second) {
        third[i.key] = i.value
    }
    println(third)
}

/*
Задание 10: Словарь с Сложными Типами
Создайте словарь, где ключами являются строки,
а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
 */
fun mapStringList() {
    val mapStrList = mutableMapOf<String, List<Int>>()
    mapStrList["One"] = listOf(1, 1, 1, 1)
    mapStrList["Two"] = listOf(2, 2, 2, 2)
}

/*
Задание 11: Использование Множества в Качестве Значения
Создай словарь, в котором ключи - это целые числа,
а значения - изменяемые множества строк.
Добавь данные в словарь.
Получи значение по ключу (это должно быть множество строк)
и добавь в это множество ещё строку.
Распечатай полученное множество.
*/
fun mapIntSet() {
    val map = mutableMapOf<Int, MutableSet<String>>()
    map[1] = mutableSetOf("one", "один", "1")
    map[2] = mutableSetOf("two", "два", "2")
    map[1]?.add("3")
    println(map[1])
}

/*
Задание 12: Поиск Элемента по Значению
Создай словарь, где ключами будут пары чисел.
Через перебор найди значение у которого пара будет содержать цифру 5
в качестве первого или второго значения.
*/
fun searchElemenMap() {
    val myMap: Map<Pair<Int, Int>, String> = mapOf(
        Pair(1, 1) to "str1",
        Pair(2, 3) to "str2",
        Pair(4, 5) to "str3"
    )

    for ((key, value) in myMap) {
        if (key.first == 5 || key.second == 5) {
            println("${key.first}, ${key.second}")
        }
    }
}
/*
======
Напиши решения задач. В каждом случае нужно проанализировать и подобрать оптимальный тип словаря.
Задание 6: Словарь Библиотека
Ключи - автор книги, значения - список книг
*/
val map1 = mapOf<String, List<String>>()

/*
Задание 12: Справочник Растений
Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
*/
val map2 = mapOf<String, MutableList<String>>()

/*
Задание 8: Четвертьфинала
Ключи - названия спортивных команд, значения - списки игроков каждой команды
*/
val map3 = mutableMapOf<String, MutableMap<Int, String>>()

/*
Задание 9: Курс лечения
Ключи - даты, значения - список препаратов принимаемых в дату
*/
val map4 = mutableMapOf<String, MutableList<String>>()

/*
Задание 10: Словарь Путешественника
Ключи - страны, значения - словари из городов со списком интересных мест.
*/
val map5 = mutableMapOf<String, MutableMap<String, MutableList<String>>>()
