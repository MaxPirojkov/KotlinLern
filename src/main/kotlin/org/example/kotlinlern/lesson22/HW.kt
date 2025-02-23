package org.example.kotlinlern.lesson22

import kotlin.math.abs
import kotlin.text.Charsets.UTF_16



fun main() {
    val array = arrayOf(1, 2, 3, 4).funArray() //1, 4

    val myChar = 'A'.funChar(1, 3, true)

    val mutList = mutableListOf(1, 2, 4, 5).funList(1, 3)

    val myLong = 1L.funLong()
    val myLong1 = null
    println(myLong1)

    val myPair = Pair(null, 2).revert()
    println(myPair) //(2, null)

    val myNumb = 10
    println(myNumb.within(1, 2)) //false

    val myEncode = "slovo".encrypt(1)
    println(myEncode) // tmpwp
    println(myEncode.decrypt(1)) // slovo

    val nameList = listOf("гротеск", "Асахи", "комната", "avocado1")

    val pid = "пидмаркоз".funPidm(nameList).toString()
    println(pid)
}