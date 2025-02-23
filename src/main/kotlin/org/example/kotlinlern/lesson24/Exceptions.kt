package org.example.kotlinlern.lesson24

// Исключения - для обработок ошибок
// это прерывание работы приложения, если не настроен перехват этого исключения  программа останавливается
// обработка исключения - это механизм поймать и обработать ошибку без прерывания работы программы

// class Throwable - все исключения наследуются от Throwable
// Error - все ошибки связанные с проблемами виртуальной машины Java, например тип OutOfMemoryError
//StackOverflowError - стэк вызовов, под них зарезервировано некоторое кол-во ячеек. и кол-во ячеек ограничено. и если будет запрос на новую. получим ошибку
// Exception - группа исключений, могут быть обработаны в апп
// IOException - исключения при работе с файлами. напрример FileNotFoundException
// RuntimeException
//NullPointerException

fun main() {
//    throw Exception("message about error")
//    val exception = Exception("message about error")
//    throw exception
    /*
        try {
            // код который может выбросить исключение
            val t = null
            t!!
            val r = listOf(1)
            r[2]
        } catch (е: NullPointerException) {
            // обработка кокретного типа исключения
            println("NullPointerException")
        } catch (e: Exception) {
            // обработка всех остальных исключений
            println("ArrayIndexOutOfBoundsException")
        } finally {
            // блок который выполняется всегда независимо от наличия исключения
            println("finally block")
        }

     */
    /*
    try {
        val myVal = "str" as Double
    } catch (e: Throwable) {   // если отлавливтаь по классу Throwable то будет любую ощибку наследуемую от этого класса отлавиливать
        println("ClassCastException")
    }
    */


//    val i = "123,0".toDouble() //NumberFormatException:
//    println(i)

//    setAge(-2)
    // функция require - обязательно для работы функции аргументы должны соответсвовать условиям. для валидности аргументов
    //функция check
    // IllegalArgumentException - эксепшн конда в функцию переданы некорректные данные
    // IllegalStateException - неверное состояние объектов.
  //  Используй IllegalArgumentException, если проблема связана с входными данными, переданными в метод.
  //  Используй IllegalStateException, если проблема связана с текущим состоянием объекта.

//    val file = File("ddddd")
//    file.createNewFile()
//    val i = file.inputStream()
//    i.close()
//    i.read()  // IOException: Stream Closed попытка чтения закрытого потока

//    val list = mutableListOf("")
//    while (true){
//        list.add("adfdsakdjmaksdm")      // OutOfMemoryError: Java heap space
//    }

//    val list = mutableListOf("")
//    try {
//        while (true) {
//            list.add("ffdjndjkfnjkd")
//        }
//    } catch (e: Throwable) {
//        println("Out of memory")
//    }
    try {
        stack()
    } catch (e: Throwable) {
        println("StackOverFlow")
    }


}

fun stack() {
    stack()             //получим StackOverflowError
}

fun setAge(age: Int) {
    check(age > 0) {
        "Возраст не может быть меньше 0"
    }
}

class OrderException(message: String): RuntimeException(message) {  //создание кастомного исключения

}