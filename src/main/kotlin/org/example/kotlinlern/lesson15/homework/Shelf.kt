package org.example.kotlinlern.lesson15.homework

class Shelf(val capacity: Int, private var items: MutableList<String>) {

    fun addItem(item: String): Boolean {
        return (canAccommodate(item) && items.add(item))
    }

    fun canAccommodate(item: String): Boolean {
        val allItems = capacity - (items.sumOf { it.length })
        return allItems - item.length >= 0
    }

    fun removeItem(item: String): Boolean {
        return items.remove(item)
    }

    fun containsItem(item: String): Boolean {
        return items.contains(item)
    }

    fun getItems(): List<String> {
        return items.toList()
    }

    fun remainingCapacity(): Int {
        return capacity - (items.sumOf { it.length })
    }
}