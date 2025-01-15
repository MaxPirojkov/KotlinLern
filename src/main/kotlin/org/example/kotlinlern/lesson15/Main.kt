package org.example.kotlinlern.lesson15

import org.example.kotlinlern.lesson15.homework.*

fun main() {
    val person = Person("John", 10) //создание объекта класса - вызов конструктора класса для инициализации
    person.sayHello()

    Logger.log("ffff")

    Calculator.add(2, 1)
    Calculator.VERSION

    val user1 = User(1, "Alice")
    println(user1) // Output: User(id = 1, name = Alicee)

    val lamp = Lamp(true)
    lamp.switcher()

    val wind = Wind(10)
    println(wind.convertMetrSec())

    val car = Car(Car.brandList[2], "A4")
    car.naming()

    val part = Party("tam syam", 15)
    part.details()

    val emo = Emotion("OMG", 45)
    emo.express()

    val moon = Moon
    moon.showPhase()

    val concert = Concert("Hifi", "HolidayInn", 10, 300, 300)
    concert.infoConcert()
    concert.buyTicket()

    val listItem = mutableListOf("Hello", "world", "Kotlin", "is", "great")
    val newList = Shelf(30, listItem)

//    newList.addItem("lang")
//    newList.removeItem("Hello")
//    newList.getItems(listItem)

    val shelf1 = Shelf(10, mutableListOf("Book"))
    val shelf2 = Shelf(15, mutableListOf("Notebook", "Pen"))

    val rack = Rack(mutableListOf(shelf1, shelf2), 10)
    rack.addItem("newList")
    rack.printContents()
}