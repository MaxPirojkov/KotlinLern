package org.example.kotlinlern.lesson8

fun main() {
    /*
    val simpleString = "this is simple string"

    val fistName = "Ivan"
    val secondName = "Ivanov"
    val fullName = "$fistName $secondName"  // конкатинация , переменная выводящаяся через $ это шаблон

    val person = Person("Max", 22)
    val intro = "My name is ${person.name} and I am ${person.age} yeras old"

    val details = "Here is ${getDetails()}"


    val x = 10
    val y = 12
    val res = "result sum of x and y = ${x + y}" // в стринг происходит вычесление

}
class Person(val name: String, val age: Int)

    fun getDetails(): String {
        return "realy intreasting"
    }
*/

// substring
//    val originalString = "Kotlin is fun"
//    val subString = originalString.substring(7) // первые 7 символов из originalString будут удалены и выведет "is fun"
//    val subString2 =
//        originalString.substring(3, 6)  // вырежет певые три символа распечатется "lin" и все остально вырежет
//    val replace = originalString.replace("n", "w") // заменит все "n" на "w"
//    val words = originalString.split(" ") // разделяет строку по указаному параметру и сохраняет их в переменную как список
//    val length = "Hello".length // выведет кол-во символов
//    val upper = "hello".uppercase() // переведет все на больщие буквы
//    val lower = "HELLO".lowercase()
//    val trimmed = "  hell   ".trim() // удаляет пробелы или симоволы
//    val starts =
//        "Kotlin".startsWith("Kot") // проверят строку слева начинается ли она на слово указанное справа, return boolean
//    val ends = "Kotlin".endsWith("lin") // проверяет окончание
//    val contains = "Hello".contains("ell")
//    val e: String? = null
//    val empty = e.isNullOrEmpty() // проверяет возвращается ли null
//
//    val blunk = " ".isNullOrBlank() // проверяет яв-ся ли объект на null / и на наличие символов - Blank
//    val repeat = "ab".repeat(3) // повторяет строку три раза
//    val letter = originalString[5] // взять символ с индексом 5
//    val indexOfChar = "Kotlin".indexOf('t') // вернет индекс символа который указали, так же можно искать по строке
//    val backReverse = "Kotl".reversed() // перевернет строку
//
//    val multiLineStr = """ // сохраняются переносы строк
//    первая строка
//      вторая строка
//    третья строка
//""".trimIndent() // .trimIndent() - удаляет лищнии пробелы

//форматирование строк
    val name1 = "Alex"
    val city = "Rome"
    val age = 32
    val friendsCount = 1002
    val rating = 4.948
    val balance = 2534.75856
    val text = """
Name: %s
City: %s
Age: %d
Friends: %,d    //числовое значение разделить на 1000
Raring: %.1f    // 
Balance: $%,.2f
""".trimIndent()

println(text.format(name1, city, age, friendsCount, rating, balance))

}






