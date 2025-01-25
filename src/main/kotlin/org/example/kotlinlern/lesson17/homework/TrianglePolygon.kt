package org.example.kotlinlern.lesson17.homework

class TrianglePolygon(
    form: String,
    size: Int,
    cornersNumber: Int,
    val isRectangle: Boolean
): Polygon(form, size, cornersNumber) {
}