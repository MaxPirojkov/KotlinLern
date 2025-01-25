package org.example.kotlinlern.lesson18.homework2shape

import kotlin.math.sin

class Triangle(val bottom: Double, val height: Double, val angleDegrees: Double) : Shape() {
    override fun area(): Double {
        val angleRadians = Math.toRadians(angleDegrees)
        return  0.5 * bottom * height * sin(angleRadians)
    }
}