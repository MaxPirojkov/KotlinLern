package org.example.kotlinlern.lesson21.homework


/*
1. Создайте функцию toMap<K, V>(keys: List<K>, values: List<V>): Map<K, V>,
которая будет создавать карту из списков ключей и значений.
Если ключей или значений больше,
то оставшиеся ключи или значения не записываем в словарь.
 */

fun <K, V> toMap(keys: List<K>, values: List<V>): Map<K, V> {
    val myMap = mutableMapOf<K, V>()

    for (i in 0 until minOf(keys.size, values.size)) {
        myMap[keys[i]] = values[i]
    }
    return myMap
}

/*
2. Напишите функцию getMiddleElement<T>(list: List<T>): T?,
которая будет возвращать средний элемент списка,
если он существует.
 */

fun <T> getMiddleElement(list: List<T>): T? {
    return if (
        list.isNotEmpty()
        && list.size % 2 != 0
        && list.size > 2
    )
        list[list.size / 2]
    else null
}

/*
3. Напишите класс ListHolder,
который будет хранить список элементов типа T
и иметь метод для добавления и получения всех элементов.
 */

class ListHolder<T> {
    private val list = mutableListOf<T>()
    fun getList(): List<T> {
        return list.toList()
    }

    fun setList(i: T) {
        list.add(i)
    }
}

/*
4. Создайте интерфейс Mapper<T, R>,
который будет определять метод
для преобразования элементов типа T в элементы типа R.
 */

interface Mapper<T, R> {
    fun convert(i: T): R
    fun listConvert(list: List<T>): List<R>
}

/*
5. Создай класс PhrasesToListOfStrings
и имплементируй интефрейс Mapper
с типами String и List<String>.
Метод преобразования должен разбивать входящую строку
по символу пробела и возвращать список из полученных слов.
 */

class PhrasesToListOfStrings() : Mapper<String, List<String>> {
    override fun convert(i: String) = i.split(" ")


    override fun listConvert(list: List<String>): List<List<String>> {
        return list.map { convert(it) }
    }

}

/*
6. Добавь к интерфейсу Mapper ещё один метод,
который будет преобразовывать список элементов типа T
в список элементов типа R.
Реализуй этот метод в классе PhrasesToListOfStrings с аналогичной механикой.
 */

/*
7. Напишите интерфейс Validator<T>,
который будет проверять значение типа T
на соответствие определенным условиям
и возвращать булево значение
(успешная или неуспешная проверка).
 */

interface Validator<T> {
    fun check(i: T): Boolean
}

/*
8. Создай класс StringValidator
и имплементируй интерфейс Validator с типом String?.
Реализуй проверку, что строка не является null,
не пустая
и не состоит из одних пробелов.
 */

/*
Создай класс OddValidator
и имплементируй интерфейс Validator типизированный по Int.
Реализуй проверку, что число чётное.
 */

class OddValidator : Validator<Int> {
    override fun check(i: Int) = i % 2 == 0
}

class StringValidator : Validator<String?> {
    override fun check(i: String?) = i.isNullOrBlank()
}

/*
10. Создай класс ListValidator
a. с дженериком, ограниченным типом Number
b. имплементируй интерфейс Validator
c. типизированный по типу List с nullable типом дженерика класса
d. Реализуй проверку:
что ни один элемент списка не является null
Ни один элемент приведённый к типу Double не равен 0.0


 */

class ListValidator<T : Number> : Validator<List<T?>> {
    override fun check(i: List<T?>): Boolean {
        return i.all { it != null && it.toDouble() != 0.0 }
    }
}

fun main() {
    val listOfKeys = mutableListOf("key1", "key2", "key3", "key4")
    val listOfValues = mutableListOf(1, 2, 3, 4)

    val myMap = toMap(listOfKeys, listOfValues)
    println(myMap)

    val middle = getMiddleElement(listOfValues)
    println(middle)

    val myVal = ListHolder<Int>()
    myVal.setList(1)
    myVal.setList(2)
    println(myVal.getList())

    val exampleString = "В Java есть класс StringTokenizer, которые можно использовать для разбиения строк"
    val exml1 = listOf("1", "2", "3")
    val exml2 = listOf("4", "5", "6")
    val str = PhrasesToListOfStrings()
    str.convert(exampleString) //[В, Java, есть, класс, StringTokenizer,, которые, можно, использовать, для, разбиения, строк]

    val result = mutableListOf<List<String>>()
    result += str.listConvert(exml1)
    result += str.listConvert(exml2)
    println(result) // [[1], [2], [3], [4], [5], [6]]

    val validator = StringValidator()
    println(validator.check(null))   // false
    println(validator.check("   ")) // false
    println(validator.check(""))   // false
    println(validator.check("d")) // true
}