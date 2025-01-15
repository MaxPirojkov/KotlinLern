package org.example.kotlinlern.lesson15.homework

class Concert(val group: String, val location: String, var price: Int, val capacity: Int, private var soldTicket: Int) {
    fun infoConcert() {
        println("Show $group, place $location, price of ticket $price, capacity of hall $capacity")
    }

    fun buyTicket() {
        if (soldTicket < capacity) {
            soldTicket += 1
        } else {
            println("sold out")
        }
    }
}