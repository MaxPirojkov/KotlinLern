package org.example.kotlinlern.lesson15

class Car(val brand: String, val model: String) {

    companion object {
        val brandList = listOf("Bmw", "Audi", "VW", "Lada")
    }

    fun naming() {
        println("I'm $brand and my model is $model")
    }
}