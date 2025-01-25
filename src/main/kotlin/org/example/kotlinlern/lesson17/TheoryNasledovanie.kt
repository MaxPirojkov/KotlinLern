package org.example.kotlinlern.lesson17

class TheoryNasledovanie {
    /*

     */

}

open class Vehicle(
    val maxWeight: Int,
    val passengerCapacity: Int,
    val serialNumber: String
) {

}

open class WheeledVehicle(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    val wheelCount: Int
): Vehicle(maxWeight, passengerCapacity, serialNumber)  // расширение класса, создаем новый класс наследуемый от Vehicle. значение получаем из конструктороа

// open class - если хотим что б от этого класс можно было наследоваться
// class- по умолчанию final, наследование не доступно
// abstract class - создать объект этого класса не сможем. наследоваться можем