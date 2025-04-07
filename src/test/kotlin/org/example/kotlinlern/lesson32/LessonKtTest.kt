package org.example.kotlinlern.lesson32

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LessonKtTest {

  @Test
  fun `Check code for phone number`() {
   val actual = textToPhone("81234567890")
   assertEquals("+7 (123) 456-78-90", actual)
  }

    @Test
    fun `no symbols`() {
        val actual = textToPhone("81234567890 Vasya")
        assertEquals("+7 (123) 456-78-90", actual)
    }

    @Test
    fun `start with +`() {
        val actual = textToPhone("71234567890")
        assertEquals("+7 (123) 456-78-90", actual)
    }
 }