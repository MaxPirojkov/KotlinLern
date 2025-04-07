package org.example.kotlinlern.lesson32.homework

fun formatPhoneNumber(input: String): String {
    val formatNumb = input.replace("\\D".toRegex(), "")
    return when (formatNumb.length) {
        10 -> formatString(formatNumb)
        11 -> {
            if (formatNumb[0] == '7' || formatNumb[0] == '8') {
                formatString(formatNumb.drop(1))
            } else {
                throw IllegalArgumentException("Неверный номер телефона: '$input'")
            }
        }

        else -> throw IllegalArgumentException("Неверный номер телефона: '$input'")
    }
}


fun formatString(input: String): String {
    return "+7 (${input.substring(0, 3)}) ${input.substring(3, 6)}-${input.substring(6, 8)}-${input.substring(8, 10)}"
}

fun main() {

    println(formatPhoneNumber("1234567890"))
}
