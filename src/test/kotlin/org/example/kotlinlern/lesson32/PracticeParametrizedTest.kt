package org.example.kotlinlern.lesson32

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class PracticeParametrizedTest {

    @ParameterizedTest
    @MethodSource("providePhoneNumbers")
    fun `check convert`(
        actualPhone: String,
        expectedPhone: String
    ){
        val actual = textToPhone(actualPhone)
        assertEquals(expectedPhone, actual)
    }

    companion object {
        @JvmStatic
        fun providePhoneNumbers() = listOf(
            arrayOf("81234567890", "+7 (123) 456-78-90"),
            arrayOf("81234567890 Vasya", "+7 (123) 456-78-90"),
            arrayOf("7(123)4567890", "+7 (123) 456-78-90")
        )
    }
}