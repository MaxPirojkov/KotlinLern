package org.example.kotlinlern.lesson26

fun main() {

    val func3: (Int) -> String = {
        it.toString() + " 2"
    }

    val valVar: (Int) -> String = {
        "${it + 5}"
    }

    func2(valVar)
    func2(func3)
}


fun function(newFunc: () -> Unit) {

}

fun func2(newFunc: (Int) -> String) {
    println(newFunc(33))
}

fun <T> func34(arg: List<T>, arg2: (List<T>) -> T): T {
    return arg2(arg)
}

fun funcAn() {
    val func = fun() {
        println("f")
    }

    val fun2: () -> Unit = {

    }

}
