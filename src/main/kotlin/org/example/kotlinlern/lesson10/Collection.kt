package org.example.kotlinlern.lesson10

fun main() {
// Массивы
// упорядоченные коллекции, фиксированного размера, одного типа, всегда изменяемые

//    val numbers = arrayOf(1, 2, 3, 4, 5) // тип просатвляется автоматически
//    val numb: Array<Int> = arrayOf(1, 2, 3, 4) // <Int> - дженерики
//
//    val double: DoubleArray = doubleArrayOf(1.2, 3.1, 4.3)

   // arrayEmpty[0]=10  присвоение значания 10 по индексу 0


// Массив имеет ограничения по размеру, ограничивается размером при создании
// убавить, прибавит размер нельзя, можно заменять значения

// создание пустого массива
//    val emptyArray = Array(size = 5) { "" }  // создасться массив с размером 5, со значениями ""
//    val emptyNullableArray: Array<Int?> = arrayOfNulls<Int>(5)


// СПИСКИ
// могут быть изменяемыми или не изменяемыми
    // last() - вернет последнее значение списка
//    val readOnlyList: List<String> = listOf("a", "b", "c") // метод listOf создает список не изменяемый
//    val mutableList: MutableList<String> =
//        mutableListOf("a", "b", "c") //изменяемый список, можно менять значениия и размер

//Set - множества
    // нет индексов
//    val numbSet: Set<Int> = setOf(1, 3, 4, 5) // хранит уникальные значения
//    val mutabNumbSet: MutableSet<Int> = mutableSetOf(1, 3, 4, 5) //, можно изменять


//Methods
//Значения в массиве можно получить по индексу
//    println(numbers[1])

    //добавление в лист по индексу
//    mutableList.add("ui")

    // в Set нет индексов, получить значение только перебором в цикле


//    val list1 = listOf(32, 53, 1, -76)
//    for (index in list1.indices) {
//        if (index == list1.lastIndex) {
//            println(list1[index] + list1[0])
//        } else {
//            println(list1[index] + list1[index + 1])
//        }
//    }
//
//    var index = list1.lastIndex
//    while (index >= 0) {
//        println("${list1[index--]}")
//    }

//    val emptyArray1 = Array(5) { 0 }
//    val arrayDouble1: DoubleArray = doubleArrayOf(1.0, 2.0, 3.0, 4.5)
//    val arrayEmpty = Array(10) {0}
//    for (i in arrayEmpty.indices){
//        arrayEmpty[i] = 10 * (i + 1)
//    }
//
//    val array2 = arrayOf("1", "2", "3", "4", "5")
//    for (i in array2.indices){       // что б изменить значение нужно передевать диапазон индеков .indices
//        array2[i] = " "
//    }


    val arrayInt1 = arrayOf(1, 2, 3)
    val arrayUnt2 = arrayOf(5, 6, 7)
    val emptyArrayInt = Array(3) {0}

    for(i in emptyArrayInt.indices){
        emptyArrayInt[i] = arrayInt1[i] + arrayUnt2[i]
    }
    println(emptyArrayInt.toList())

    val list1 = listOf<Int>() // создали пустой неизменяемый список
    val list3 = listOf("s", "t", "r")
    for (i in list3){
        println(i)
    }
    val list4 = mutableListOf<Float>()
    list4.add(45F) // значений нет, индексы неизвестны
    list4.add(22F)
    list4.remove(45F) // удалиться ячайка со значением 45F
    list4.removeAt(0) // удаление по индексу

    val emptySet = setOf<Int>()
    val setNum = setOf(1, 3, 4, 5)
    val setNum2 = mutableSetOf(1, 2, 3)
    setNum2.add(8)
    setNum2.remove(2)
    for (i in setNum2){
        println(i * i)
    }

    val set1 = setOf(1, 2, 3)
    val set2 = setOf(3, 4, 5)
    val emptySet1 = mutableSetOf<Int>()
    for (i in set1) {
        emptySet1.add(i)
    }
    for (i in set2){
        emptySet1.add(i)
    }

}

fun findNumber(setNum: Set<Int>, numb: Int): Boolean {
    for(i in setNum){
        if (i == numb){
            return true
        }
    }
    return false  // в случае если не нашли число в сет
}