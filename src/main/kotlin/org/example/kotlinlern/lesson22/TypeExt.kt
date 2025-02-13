package org.example.kotlinlern.lesson22

import kotlin.math.abs

/*
1 Тренируемся составлять сигнатуру функции расширяющей класс.
Можешь проявить свою творческую жилку и в коде функции что-нибудь сделать с входящими данными,
чтобы вернуть итоговый результат или распечатать его, если нет возвращаемого типа.
a. Определите функцию-расширение для массива чисел,
которая не принимает аргументов и возвращает пару из чисел.
 */

fun Array<Int>.funArray(): Pair<Int, Int> {
    return Pair(this.first(), this.last())
}

/*
Напишите функцию-расширение для класса символа,
допускающего null,
которая принимает три аргумента:
два типа число и один булево,
и ничего не возвращает.
 */

fun Char?.funChar(a: Int, b: Int, c: Boolean) {
}

/*
Создайте функцию-расширение для класса изменяемого списка элементов с дженериком,
которая принимает два аргумента:
один типа дженерик, допускающий null,
и другой типа число,
и возвращает значение типа дженерик, допускающий null.
 */

fun <T> MutableList<T>.funList(a: T?, b: Int): T? {
    return a
}


/*
Реализуйте функцию-расширение для класса словаря
допускающего null с ключами дженериком
и значениями типа список из такого же дженерика,
которая принимает один аргумент типа число
и возвращает словарь допускающий null
с ключами типа строка и значениями типа дженерика допускающего null.
 */

//     fun <K, V> Map<K?, List<V>>.funMap(a: Int): Map<String?, V?> {
//         return mapOf(key to value)
//     }
/*
Определите функцию-расширение для класса длинного числа,
допускающее null,
которая не принимает аргументов и возвращает строку.
 */

fun Long?.funLong(): String {
    return "Функция расширения Long"
}

/*
Задача 3: Переворот элементов пары
Реализуйте метод расширения revert для класса Pair,
который меняет местами первый и второй элементы пары.
Метод должен возвращать новую пару с перевернутыми элементами.
Протестируйте эту функцию на различных парах значений, в том числе null.

 */
fun <A, B> Pair<A?, B?>.revert(): Pair<B?, A?> {
    return Pair(this.second, this.first)
}

/*
Задача 4: Проверка допустимого отклонения числа
Реализуйте метод расширения within для класса Number,
который проверяет,
что текущее число отклоняется от эталонного не более допустимого значения.
Метод принимает два параметра:
other — число для сравнения
и deviation — максимально допустимое отклонение.
Метод должен возвращать true,
если разница между текущим числом
и числом для сравнения не превышает заданное отклонение.
Протестируйте функцию на разных типах чисел.
Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.
 */

fun Number.within(other: Number, deviation: Number): Boolean {
    return abs(this.toInt() - other.toInt()) <= deviation.toInt()
}

/*
Задача 5: Кодер-декодер строк
Реализуйте для класса String два метода расширения:
encrypt и decrypt.
Метод encrypt должен сдвигать каждый символ исходной строки
на заданное число позиций вперед по таблице Unicode,
а метод decrypt — на то же число позиций назад.
Оба метода принимают один параметр base типа Int,
который определяет величину сдвига.
Протестируйте вашу реализацию,
убедившись, что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.
Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.
 */

fun String.encrypt(base: Int): String {
    return this.map { (it.code + base).toChar() }.joinToString ("" )
}

fun String.decrypt(base: Int): String {
    return this.map {
        (it.code -  base).toChar()
    }.joinToString ("")
}

/*
Собери пидмаркоз!
Напиши метод расширения строки,
который будет принимать список имён пользователей
и выводить в консоли эту строку побуквенно
в столбик: имя автора и букву под ним. - НЕ решил
Если сможешь повторить оригинальный
шаблон вывода ответов с помощью похожих ASCII символов,
 */

fun String.funPidm(list: List<String>){
    for (i in 0 until  this.length){
        println(list[(i % list.size)])
        println(this[i])
    }
}