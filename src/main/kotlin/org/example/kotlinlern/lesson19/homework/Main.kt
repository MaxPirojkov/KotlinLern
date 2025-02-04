package org.example.kotlinlern.lesson19.homework

fun main() {
    val myValue = ChildrenClass("privateVal", "protectedVal", "publicVal")
    myValue.publicField = "Антонио Бандерас"
    myValue.setProtectedField1("set🕵🏽‍♂️")
    myValue.setPrivateField("new private 💪🏻")
    println( myValue.getAll())


}