package org.example.kotlinlern.lesson7

    //Циклы
//    for (item in collection){
//        // тело цикла
//    }
//    for (i in listOf(1,2,3)){
//        //body of cycle
//    }

    //Цикл while - сначала думает, потом делает
//    while(condition){
//        //тело цикла
//    }

//    var counter = 10
//    while (counter-- > 0) {
//        println(counter)
//    }

    // Цикл do while  -  сначала делает. потом думает
//    do {
//        println("+")
//    } while (false)

    // Операторы в циклах
    //break - завершает цикл совсем
    //continue - продожает с указанной итерации
//    for (i in 1 .. 10) {
//        if (i == 2) continue
//        if(i == 7) break
//        println(i)
//    }
    fun main() {
        var count = 1
        var sum = 0

        while (count <= 10){
            sum +=count++
            println(sum)
        }
    }




