package org.example.kotlinlern.lesson31.unittest.homework

import org.example.kotlinlern.lesson13.isNotEmpty
import kotlin.math.min

class CerealStorageImpl(
    override val containerCapacity: Float,
    override val storageCapacity: Float
) : CerealStorage {
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
        require(amount >= 0) {
            "Количество крупы не может быть отрицательным"
        }
        val currentAmount = getAmount(cereal)
        return if (currentAmount >= amount) {
            storage[cereal] = currentAmount - amount
            amount
        } else {
            storage.remove(cereal)
            currentAmount
        }

    }

    override fun removeContainer(cereal: Cereal): Boolean {
        return when {
            !storage.contains(cereal) -> false
            getAmount(cereal) == 0f -> {
                storage.remove(cereal)
                true
            }
            else -> false
        }
    }

    override fun getAmount(cereal: Cereal): Float {
        return storage.getOrDefault(cereal, 0f)
    }

    override fun getSpace(cereal: Cereal): Float {
        return containerCapacity - getAmount(cereal)
    }

    override fun toString(): String {
        return when {
            storage.size == 0 -> "Storage is empty"
            else -> ("Cereal Storage: {${storage.map { "${it.key.local}=${it.value}"}.joinToString(", ")}}")
        }
    }

    private fun checkStorageCapacity(cereal: Cereal) {
        if (storage.contains(cereal)) return
        check(storageCapacity >= (storage.size + 1) * containerCapacity) {
            "Недостаточно места в хранилище для нового контейнера"
        }
    }

}
