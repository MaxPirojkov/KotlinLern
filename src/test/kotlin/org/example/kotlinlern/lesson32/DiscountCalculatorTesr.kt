package org.example.kotlinlern.lesson32

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DiscountCalculatorTesr {
    @Test
    fun `should return original price when discount is 0`() {
        val originalPrice = 100.0
        val discountPercentage = 0
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(100.0, actualPrice, 0.01, "Цена без скидки")
    }

    @Test
    fun `should calculate 50 percent discount`() {
        val originalPrice = 200.0
        val discountPercentage = 50
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(100.0, actualPrice, 0.01, "50% скидка")
    }

    @Test
    fun `should return 0 when discount is 100 percent`() {
        val originalPrice = 50.0
        val discountPercentage = 100
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(0.0, actualPrice, 0.01, "Полная скидка")
    }

    @Test
    fun `should calculate 25 percent discount`() {
        val originalPrice = 99.99
        val discountPercentage = 25
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(74.99, actualPrice, 0.01, "25% скидка")
    }

    @Test
    fun `should throw exception when original price is negative`() {
        val originalPrice = -10.0
        val discountPercentage = 10
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            calculateDiscountedPrice(originalPrice, discountPercentage)
        }
    }

    @Test
    fun `should throw exception when discount percentage is out of range`() {
        val originalPrice = 100.0
        val discountPercentage = 150
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            calculateDiscountedPrice(originalPrice, discountPercentage)
        }
    }


}