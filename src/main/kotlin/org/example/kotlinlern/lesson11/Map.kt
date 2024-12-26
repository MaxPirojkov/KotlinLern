package org.example.kotlinlern.lesson11

// Словари
// Класс Pair используется в map для передачи пары ключ значения
fun main() {
    val pair: Pair<Int, String> = 1 to "a"
    val pair2 = Pair(1, "a")

    pair.first // обращение к первому значению
    pair.second // обращение ко второму значению


    // Map
    val emptyMap: Map<String, String> = mapOf<String, String>() // создали пустой массив

    // инициализация
    val capitals = mapOf(
        "Russia" to "Moscow",
        "France" to "Paris"
    )

    val map = mapOf(1 to "a", 2 to "b", 3 to "c") //неизменяемый словарь

    val mutableMap = mutableMapOf("Russia" to "Moscow", "France" to "Paris") // изменяемый словарь

    // индексов нет, уникальный только ключ
    mutableMap["Germany"] = "Berlin"  // добавление в словарь ключ значение, если ключ уже такой есть - перезапишет значение
    mutableMap.remove("France") // удаление по ключу, удаляет и ключ и значение

    //Циклы
    for (entries in mutableMap){
        println("${entries.key} : ${entries.value}")
    }

//Null
    val nullMap = mutableMapOf<String?, Int>(null to 1)





}