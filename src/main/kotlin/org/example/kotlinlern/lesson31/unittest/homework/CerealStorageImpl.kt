package org.example.kotlinlern.lesson31.unittest.homework

import kotlin.math.min

class CerealStorageImpl(
    override val containerCapacity: Float,
    override val storageCapacity: Float
) : CerealStorage {
    // Блок инициализации класса. Выполняется сразу при создании объекта
    init {
        require(containerCapacity >= 0) {
            "Ёмкость контейнера не может быть отрицательной"
        }
        require(storageCapacity >= containerCapacity) {
            "Ёмкость хранилища не должна быть меньше ёмкости одного контейнера"
        }
    }

    private val storage = mutableMapOf<Cereal, Float>()

    override fun addCereal(cereal: Cereal, amount: Float): Float {
        require(amount >= 0) {
            "Количество крупы не может быть отрицательным"
        }
        checkStorageCapacity(cereal)
        val currentAmount = storage.getOrDefault(cereal, 0f)
        val amountForAdding = min(getSpace(cereal), amount)
        storage[cereal] = currentAmount + amountForAdding
        return amount - amountForAdding
    }

    override fun getCereal(cereal: Cereal, amount: Float): Float {
        TODO("Not yet implemented")
    }

    override fun removeContainer(cereal: Cereal): Boolean {
        TODO("Not yet implemented")
    }

    override fun getAmount(cereal: Cereal): Float {
        return storage.getOrDefault(cereal, 0f)
    }

    override fun getSpace(cereal: Cereal): Float {
        return containerCapacity - getAmount(cereal)
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }

    private fun checkStorageCapacity(cereal: Cereal) {
        if (storage.contains(cereal)) return
        check(storageCapacity >= (storage.size + 1) * containerCapacity) {
            "Недостаточно места в хранилище для нового контейнера"
        }
    }

}
