package org.example.kotlinlern.lesson15.homework

class Rack(private var shelves: MutableList<Shelf>, private val capacityRack: Int) {

    fun removeShelf(indexOfShelf: Int): Boolean {
        if (indexOfShelf in shelves.indices) {
            shelves.removeAt(indexOfShelf)
            return true
        }
        return false
    }


    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size < capacityRack) {
            shelves.add(shelf)
            return true
        }
        return false
    }

    fun addItem(item: String): Boolean {
        return shelves.any { it.addItem(item) }
    }

    fun removeItem(item: String): Boolean {
        return shelves.any {it.removeItem(item)}
    }

    fun containsItem(item: String): Boolean {
        return shelves.any { it.containsItem(item) }
    }

    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

    fun printContents() {
        for ((index, shelf) in shelves.withIndex()) {
            println("Shelf index - $index \nCapacity: ${shelf.capacity}, \nRemaining Capacity: ${shelf.remainingCapacity()}\nItems: ${shelf.getItems()}")
        }
    }




}