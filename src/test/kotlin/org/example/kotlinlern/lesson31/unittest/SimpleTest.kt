package org.example.kotlinlern.lesson31.unittest

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SimpleTest {

    private lateinit var testList: MutableList<String>

    @BeforeEach
    fun setUp() {
        //Инициализация перед каждым тестом
        testList = mutableListOf("one", "two", "three")
        println("Список инициализиирован перед тестом")
    }

    @AfterEach
    fun tearDown() {
        //Очистка после каждого теста
        testList.clear()
        println("Список очищен после теста")
    }

    @Test   // Анотация начинается с символа @
    fun testAddElement() {
        //Добавляем элемент и проееряем размер списка
        testList.add("four")
        assertEquals(4, testList.size, "Размер списка должен быть 4")
    }

    @Test
    fun testRemoveElement() {
        //Удаляем элемент и проверяем размер списка
        testList.remove("one")
        assertEquals(2, testList.size, "Размер списка должен быть 2")
    }
}