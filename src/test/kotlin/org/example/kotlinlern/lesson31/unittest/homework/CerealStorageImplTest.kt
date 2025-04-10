package org.example.kotlinlern.lesson31.unittest.homework

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CerealStorageImplTest {

    private val storage = CerealStorageImpl(
        containerCapacity = 10f,
        storageCapacity = 20f
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
    fun addCereal() = with(storage) {
        storage.addCereal(Cereal.RICE,2f)
        assertEquals(2f, getAmount(Cereal.RICE))
    }

    @Test
    fun addMultipleCereal() = with(storage) {
        addCereal(Cereal.RICE, 1.1f)
        addCereal(Cereal.PEAS, 2.7f)
        assertAll(
            { assertEquals(1.1f, getAmount(Cereal.RICE)) },
            { assertEquals(2.7f, getAmount(Cereal.PEAS)) }
        )
    }

    @Test
    fun `should return 0 if container not full`() = with(storage) {
        assertEquals(0f, addCereal(Cereal.BUCKWHEAT, 9.9f))
    }

    @Test
    fun `should return rest if added cereal is biggest than container empty space`() = with(storage) {
        assertEquals(0.1f, addCereal(Cereal.PEAS, 10.1f), 0.01f)
    }

    @Test
    fun `should throw if cereal amount is negative`(): Unit = with(storage) {
        assertThrows(IllegalArgumentException::class.java) {
            addCereal(Cereal.RICE, -1f)
        }
    }
    @Test
    fun `should throw when storage don't have space for new container`(): Unit = with(storage) {
        addCereal(Cereal.RICE, 20f)
        addCereal(Cereal.PEAS, 10f)
        assertThrows<IllegalStateException> {
            addCereal(Cereal.BUCKWHEAT, 11f)
        }
    }

//  getCereal
    @Test
    fun `getCereal returns requested amount when enough cereal is available`() = with(storage) {
        addCereal(Cereal.RICE, 5f)
        assertEquals(3f, getCereal(Cereal.RICE, 3f), 0.01f)
    }

    @Test
    fun `getCereal returns all available amount when requested more`() = with(storage) {
        addCereal(Cereal.RICE, 5f)
        assertEquals(5f, getCereal(Cereal.RICE, 7f), 0.01f)
        assertEquals(0f, getAmount(Cereal.RICE), 0.01f)
    }

    @Test
    fun `getCereal returns 0 when no cereal is present`() = with(storage) {
        assertEquals(0f, getCereal(Cereal.RICE, 3f), 0.01f)
    }

    @Test
    fun `getCereal throws IllegalArgumentException for negative amoumt`(): Unit = with(storage) {
        assertThrows<IllegalArgumentException> {
            getCereal(Cereal.RICE, -1f)
        }
    }

    //removeContainer
    @Test
    fun `removeContainer should clear empty container given cereal`() = with(storage) {
        addCereal(Cereal.RICE, 0f)
        assertTrue(removeContainer(Cereal.RICE))
    }

    @Test
    fun `removeContainer should return false if container is not empty`() = with(storage) {
        addCereal(Cereal.RICE, 1f)
        assertFalse(removeContainer(Cereal.RICE))
    }

    @Test
    fun `removeContainer should return false if there no container`() = with(storage) {
        assertFalse(removeContainer(Cereal.MILLET))
    }

    //getAmount()
    @Test
    fun `getAmount should return 0f if container doesn't add`() = with(storage) {
        assertEquals(0f, getAmount(Cereal.RICE))
    }

    @Test
    fun `getAmount should return added amount`() = with(storage) {
        addCereal(Cereal.RICE, 5.5f)
        assertEquals(5.5f, getAmount(Cereal.RICE), 0.01f)
    }

    @Test
    fun `getAmount should return the exact value after add and get container`() = with(storage) {
        addCereal(Cereal.RICE, 5.5f)
        getCereal(Cereal.RICE, 3f)
        assertEquals(2.5f, getAmount(Cereal.RICE), 0.01f)
    }

    @Test
    fun `getAmount should return unchanged value after failed removeContainer`() = with(storage) {
        addCereal(Cereal.RICE, 5f)
        removeContainer(Cereal.RICE)
        assertEquals(5f, getAmount(Cereal.RICE), 0.01f)
    }

    //getSpace
    @Test
    fun `getSpace should return 0f if container is full`() = with(storage) {
        addCereal(Cereal.RICE, 10f)
        assertEquals(0f, getSpace(Cereal.RICE), 0.01f)
    }

    @Test
    fun `getSpace should return 10f if container is empty`() = with(storage) {
        addCereal(Cereal.RICE, 0f)
        assertEquals(10f, getSpace(Cereal.RICE), 0.01f)
    }

    @Test
    fun `getSpace should return balance if there free part of container`() = with(storage) {
        addCereal(Cereal.RICE, 4f)
        assertEquals(6f, getSpace(Cereal.RICE), 0.01f)
    }

    //toString()
    @Test
    fun `toString should return storage is empty when there no cereals`() = with(storage) {
        assertEquals("Storage is empty", toString())
    }

    @Test
    fun `toString should print cereal and value in storage when there is one cereal`() = with(storage) {
        addCereal(Cereal.BULGUR, 5f)
        assertEquals("Cereal Storage: {Булгур=5.0}", toString())
    }

    @Test
    fun `toString should print all cereal and value in storage `() = with(storage) {
        addCereal(Cereal.BULGUR, 5f)
        addCereal(Cereal.RICE, 3f)
        assertEquals("Cereal Storage: {Булгур=5.0, Рис=3.0}", toString())
    }

    @Test
    fun `toString should print all cereal and value in storage after operation`() = with(storage) {
        addCereal(Cereal.BULGUR, 5f)
        getCereal(Cereal.BULGUR, 3f)
        assertEquals("Cereal Storage: {Булгур=2.0}", toString())
    }

}