package org.example.kotlinlern.lesson32

import jdk.jfr.Percentage

// параметеризация тестов


fun calculateDiscountedPrice(originalPrice: Double, discountPercentage: Int): Double {
    require(originalPrice >= 0) {"Цена должна быть не отрицательной"}
    require(discountPercentage in 0 .. 100) {"Скидка должна быть от 0 до 100 %"}

    return originalPrice * (1 - discountPercentage / 100.0)
}


//
//
//8952321 6548
//
//521654

fun textToPhone(phoneNumb: String): String {
    return phoneNumb
}