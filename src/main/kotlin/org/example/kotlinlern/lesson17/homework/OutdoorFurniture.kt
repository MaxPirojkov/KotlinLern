package org.example.kotlinlern.lesson17.homework

class OutdoorFurniture(
    room: String,
    type: String,
    val waterResistance: Boolean
): Furniture(room, type) {
}