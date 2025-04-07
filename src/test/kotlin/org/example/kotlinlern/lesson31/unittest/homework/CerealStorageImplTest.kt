package org.example.kotlinlern.lesson31.unittest.homework

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CerealStorageImplTest {

    private val storage = CerealStorageImpl(
        containerCapacity = 10f,
        storageCapacity = 15f
    )

    @Test
    fun `storageCapacity must be greater than containerCapacity`() {
        assertThrows<IllegalArgumentException> {
            CerealStorageImpl(10f, 9f)
        }
    }

    @Test
    fun `container capacity must throw IllegalArgumentException if negative`() {
        assertThrows<IllegalArgumentException> {
            CerealStorageImpl(
                containerCapacity = -1f,
                storageCapacity = 10f
            )
        }
    }

    @Test
    fun `storageCapacity should not throw exception if greater than or equal to containerCapacity`() {
        assertTrue(
           storage.storageCapacity >= storage.containerCapacity
        )
    }

    @Test
    fun addCeral() = with(storage) {
        storage.addCereal(Cereal.RICE,2f)
        assertEquals(2f, getAmount(Cereal.RICE))
    }

//    @Test
//    fun addExtraCeral() = with(storage) {
//        addCereal(Cereal.RICE, 2f)
//        addCereal(Cereal.RICE, 4f)
//        assertEquals(6f, getAmount(Cereal.RICE))
//    }


//    @Test
//    fun addMultipleCereal() = with(storage) {
//        addCereal(Cereal.RICE, 1.1f)
//        addCereal(Cereal.PEAS, 2.7f)
//        assertAll(
//            { assertEquals(1.1f, getAmount(Cereal.RICE)) },
//            { assertEquals(2.7f, getAmount(Cereal.PEAS)) }
//        )
//    }

    @Test
    fun `should return 0 if container not full`() = with(storage) {
        assertEquals(0f, addCereal(Cereal.BUCKWHEAT, 9.9f))
    }

    @Test
    fun `should return rest if added cereal is biggest than container empty space`() = with(storage) {
        Assertions.assertEquals(0.1f, addCereal(Cereal.PEAS, 10.1f), 0.01f)
    }

    @Test
    fun `should throw if cereal amount is negative`(): Unit = with(storage) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            addCereal(Cereal.RICE, -1f)
        }
    }
//    @Test
//    fun `should throw when storage don't have space for new container`(): Unit = with(storage) {
//        addCereal(Cereal.RICE, 0.1f)
//        addCereal(Cereal.PEAS, 0.1f)
//        assertThrows(IllegalStateException::class.java) {
//            addCereal(Cereal.BUCKWHEAT, 0.1f)
//        }
//    }







}