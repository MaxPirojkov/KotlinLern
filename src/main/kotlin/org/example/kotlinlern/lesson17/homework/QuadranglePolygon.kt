package org.example.kotlinlern.lesson17.homework

class QuadranglePolygon(
    form: String,
    size: Int,
    cornersNumber: Int,
    val isRegular: Boolean
): Polygon(form, size, cornersNumber) {
}