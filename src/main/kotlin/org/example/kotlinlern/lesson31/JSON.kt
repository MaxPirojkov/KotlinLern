package org.example.kotlinlern.lesson31

import com.google.gson.Gson
import com.google.gson.GsonBuilder

// JSON формат представления данных, понятный человеку и машине

data class Address(
    val street: String,
    val city: String,
    val postalCode: Int
)

data class User(
    val id: Int,
    val name: String,
    val isActive: Boolean,
    val address: Address
)

fun main() {
    val address = Address("Baker street", "London", 221)
    val user = User(1, "Sherlok Holmes", true, address)

    val gson1 = GsonBuilder()
        .setPrettyPrinting()   //красивое форматирование
        .serializeNulls()      // Включить null поля в JSON
        .create()
    val json1 = gson1.toJson(user)
    println("JSON1: $json1")

    val gson = Gson()      //Создаем экземпляр GSON
    val json = gson.toJson(user)     // Сериализация объекта
    println("JSON: $json")

    val user1 = gson.fromJson(json, User::class.java) // Десериализация JSON в объект
    println("User: $user")
}

