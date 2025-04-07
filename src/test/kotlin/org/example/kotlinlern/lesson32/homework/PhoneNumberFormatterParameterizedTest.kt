package org.example.kotlinlern.lesson32.homework

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertFailsWith

class PhoneNumberFormatterParameterizedTest {
    @ParameterizedTest
    @MethodSource("providePhoneNumbers")
    fun `check format number`(
        actualPhone: String,
        expectedPhone: String
    ) {
        val actual = formatPhoneNumber(actualPhone)
        kotlin.test.assertEquals(expectedPhone, actual)
    }

    @ParameterizedTest
    @MethodSource("provideInvalidPhoneNumbers")
    fun `check invalid phone numbers throws exception`(invalidPhone: String) {
        assertFailsWith<IllegalArgumentException> {
            formatPhoneNumber(invalidPhone)
        }
    }


    companion object {
        @JvmStatic
        fun providePhoneNumbers() = listOf(
            arrayOf("8 (922) 941-11-11", "+7 (922) 941-11-11"),
            arrayOf("79229411111", "+7 (922) 941-11-11"),
            arrayOf("+7 922 941 11 11", "+7 (922) 941-11-11"),
            arrayOf("9229411111", "+7 (922) 941-11-11"),
            arrayOf("abc +7 922 941 11 11", "+7 (922) 941-11-11")
        )


        @JvmStatic
        fun provideInvalidPhoneNumbers() = listOf(
            "12345",
            "+1 (922) 941-11-11",
            "123456789012",
            "92294111111",
            "abcde"
            )
    }
}