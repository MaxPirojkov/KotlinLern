package org.example.kotlinlern.lesson32

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DiscountCalculatorParameterizedTest {

    @ParameterizedTest
    @MethodSource("provideDiscountData")
    fun `should calculate discounted price correctly`(
        originalPrice: Double,
        discountPercentage: Int,
        expectedPrice: Double
    ) {
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(expectedPrice, actualPrice, 0.01, "Цена после скидки рассчитана неверно")
    }

    @ParameterizedTest
    @MethodSource("provideIntervalPrices")
    fun `should throw exception for invalid original price`(
        originalPrice: Double,
        discountPercentage: Int
        ) {
        assertThrows<IllegalArgumentException>("Цена должна быть не отрицательной") {
            calculateDiscountedPrice(originalPrice, discountPercentage)
        }
    }

    @ParameterizedTest
    @MethodSource("provideInvalidDiscounts")
    fun `should throw exception for invalid discount percentage`(
        originalPrice: Double,
        discountPercentage: Int
    ) {
        assertFailsWith<IllegalArgumentException>("Цена должна быть от 0 до 100") {
            calculateDiscountedPrice(originalPrice, discountPercentage)
        }
    }


    companion object {
        @JvmStatic
        fun provideDiscountData() = listOf(
            arrayOf(100.0, 0, 100.0), //Без скидки
            arrayOf(200.0, 50, 100.0), // 50% скидка
            arrayOf(50.0, 100, 0.0), //ПОлная скидка
            arrayOf(99.99, 25, 74.99) // 25% скидка
        )

        @JvmStatic
        fun provideIntervalPrices() = listOf(
            arrayOf(-10.0, 10), // Отрицательная цена
            arrayOf(-50.0, 50) // Отрицательная цена с другой скидкой
        )

        @JvmStatic
        fun provideInvalidDiscounts() = listOf(
            arrayOf(100.0, -10), // Скидка меньше 0
            arrayOf(200.0, 150) //Скидка больше 100
        )
    }
}

