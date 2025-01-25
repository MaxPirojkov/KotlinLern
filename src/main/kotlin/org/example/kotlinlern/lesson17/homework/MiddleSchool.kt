package org.example.kotlinlern.lesson17.homework

open class MiddleSchool(
    level: String,
    license: Int,
    val eveningSchool: String
): Institution(level, license) {
}