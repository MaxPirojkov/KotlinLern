package org.example.kotlinlern.lesson31.unittest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class CalculatorTest {

    @Test
    fun plus() {
        val calculator = Calculator()
        val  actual = calculator.plus(2, 3)
        Assertions.assertEquals(5, actual)
    }
}