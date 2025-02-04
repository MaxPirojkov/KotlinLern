package org.example.kotlinlern.lesson18.homework21

class GoodsBasket {
    private val map: MutableMap<Int, Int> = mutableMapOf()

    override fun toString(): String {
        return "Корзина содержит количество артикулов: ${map.keys.size}, количество всего товара ${map.values.sum()}"
    }

    fun addToCart(itemId: Int): MutableMap<Int, Int> {
        if (map.containsKey(itemId)) {
            map[itemId] = map.getOrDefault(itemId, 0) + 1
        } else {
            map[itemId] = 1
        }
        return map
    }

    fun addToCart(itemId: Int, amount: Int): MutableMap<Int, Int> {
        if (map.containsKey(itemId)) {
            map[itemId] = map.getOrDefault(itemId, 0) + amount
        } else {
            map[itemId] = amount
        }
        return map
    }

    fun addToCart(map: MutableMap<Int, Int>) {
        for ((itemId, amount) in map) {
            addToCart(itemId, amount)
        }
    }

    fun addToCart(list: List<Int>): MutableMap<Int, Int> {
        for (i in list) {
            addToCart(i)
        }
        return map
    }


}

fun main() {
    val myMap = mutableMapOf(100 to 1, 101 to 2, 103 to 3, 104 to 4)
    val myList = listOf(102, 100, 101, 103, 104)
    val myVal = GoodsBasket()
    myVal.addToCart(1, 4)
    myVal.addToCart(1)
    myVal.addToCart(myMap)
    myVal.addToCart(myList)

    println(myVal) //Корзина содержит количество артикулов: 4, количество всего товара 10

}