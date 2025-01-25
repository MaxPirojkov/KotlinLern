package org.example.kotlinlern.lesson17.homework

class PrimarySchool(
    level: String,
    license: Int,
    val numberOfStudents: Int
): Institution(level, license) {
}