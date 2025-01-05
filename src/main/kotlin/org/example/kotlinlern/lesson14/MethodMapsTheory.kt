package org.example.kotlinlern.lesson14

fun main() {
    val fruitsPrices = mapOf("apple" to 2.99, "banana" to 1.99, "cherry" to 3.2)

    for (entry in fruitsPrices.entries) { // данные в словарях хранятся в виде entries. Класс Entry - имеет ключ и значение
        println("Key: ${entry.key}, Value: ${entry.value}") // entry.key, entry value
    }

    //Деструктуризация - применяется в словарях
    for ((fruit, price) in fruitsPrices) {
        println("key: $fruit, Value: $price")
    }

    val entries = fruitsPrices.entries
    val key = fruitsPrices.keys
    val values = fruitsPrices.values

    // методы получения элементов
  //  val priceOfPearOrElse =
  //      fruitsPrices.getOrElse("pear") { throw IllegalArgumentException() } // вернет цену или ошибку если такого ключа нет
    val priceOfApple =
        fruitsPrices.getValue("apple") // вернет цену или null ошибку - опасно. перед использованием сделать проверку
    val priceOfPearOrDefault =
        fruitsPrices.getOrDefault("pear", 0.0) // вернет значение по ключу, если нет дефолтное значение - безопасно

    // методы изменение состава словаря
    val fruitWithoutBanana =
        fruitsPrices - "banana"  // минус - это метод создает новый словарь с теми же элемента и удаляет то что указали
    val fruitWithPineapple = fruitsPrices + ("pineapple" to 4.5) // добавляем элемент
    val mutableFruits: MutableMap<String, Double> = fruitsPrices.toMutableMap()

    mutableFruits["kiwi"] = 2.75 // add element
    mutableFruits.putAll(mapOf("lime" to 1.1, "avocado" to 1.1)) // добавляет все элементы в словарь
    mutableFruits.remove("apple") // delete element
    mutableFruits.clear() // очистит

    val containsApple = fruitsPrices.containsKey("apple")   // проверяет есть ли значение в ключах
    val containsValue1_5 = fruitsPrices.containsValue(1.5)
    val isEmpty = fruitsPrices.isEmpty()
    val isNotEmpty = fruitsPrices.isNotEmpty() // если есть хоть одно значение - не пустой
    val areAllFruitsExpensive =
        fruitsPrices.all { it.value > 1.0 } // после проверки всех элементов словаря, если все элементы подходят условию - тру
    val isAnyFruitCheap =
        fruitsPrices.any { it.value < 1.0 }  //  проверяет все элементы если хоть один соответствует условию - тру

    val filteredByPrice = fruitsPrices.filter { it.value > 1.0 }
    val filteredByKeys = filteredByPrice.filterKeys { it.startsWith("a") }
    val filteredByValue = fruitsPrices.filterValues { it < 2.0 }
    val filteredNotApple = fruitsPrices.filterNot { it.key == "apple" }
    val countExpensiveFruits = fruitsPrices.count { it.value > 1.5 }

    // преобразование

    val increasedPrices = fruitsPrices.mapValues { it.value * 1.2 }
    val fruitNamesUppercase = fruitsPrices.mapKeys { it.key.uppercase() }
    val fruitsList = fruitsPrices.map { "${it.key} costs ${it.value}" }

    val toMap = mutableFruits.toMap()
    val toMutableMap = fruitsPrices.toMutableMap()

    fruitsPrices.forEach { (fruit, price) ->
        println("$fruit costs $price")
    }
    fruitsPrices.forEach {
        println("${it.key} costs ${it.value}")
    }


    fun classWork() {
        val map = mapOf<String, Int>()
        for (entry in map.entries) {
            println("${entry.key} = ${entry.value}")
        }
        println(map.values)
        println(map.keys)


        val mapProduct = mapOf<String, Int>()
        println(mapProduct.getOrElse("tomatos") { throw Exception("no") })

        val listOfFruits =
            fruitsPrices.map { "Продукты ${it.key} в количестве ${it.value}" } // в list список передаем элементы из map словаря
        println(fruitsPrices)
        val allItems = mapProduct.all { it.value > 10 } //метод запускает цикл for и проверяет каждый элемент с условием. если хоть один не подходит вернет false
        val anyItem = mapProduct.any { it.value > 100 } //цикл for, вернут true если хоть один будет выполнять условие


    }


}