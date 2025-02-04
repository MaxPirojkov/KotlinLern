package org.example.kotlinlern.lesson19

/*
Инкапсуляция - это подход, который позволяет нам спрятать от прямого доступа поля, методы, классы
важно делать все что можно приватным и только без чего нельзя работать снаружи - публичным

public - проставляется по умолчанию ко всем данным, обратиться можно из любого места проекта
private - доступ в к объекту в рамках файла
protected - видны в классе в котором определены и в классах наследниках
internal - модификатор - доступ к объекту в рамках модуля

 */

class Account (private var balance: Double) {
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
        }
    }

    fun getBalance(): Double {
        return balance
    }
}

open class Person(private val name: String, protected val age: Int) {
    //публичный метод
    fun great() {
        println("Привет, меня зовут $name")
    }

    // защищенный метод
    protected fun getName(): String {
        return name
    }

    // приватный метод
    private fun secret() {
        println("Это секретный метод")
    }
}

class Student(name: String, age: Int, val studentId: Int): Person(name, age) {
    // Публичный класс
    fun study() {
        println("${getName()} учиться")
    }

    fun showAge() {
        //обращаемся к защещенному полю age из родительского класса
        println("Мне $age лет")
    }

}

class Lamp {
    private var isOn = false

    fun ternOn() {
        isOn = true
    }

    fun ternOff() {
        isOn = false
    }
}

class GameConsole {
    private fun loadGame(name: String) {

    }

    private fun initHardware() {

    }

    fun startGame(name: String) {
        initHardware()
        loadGame(name)
    }
}

class Atm(private var balance: Float) {
    private var myPin = "2323"

    fun deposit(amount: Float, pin: String){
        checkPin(pin)
    }

    fun withdraw(amount: Float, pin: String): Float {
        checkPin(pin)
        return amount
    }

    fun getBalance(pin: String): Float {
        checkPin(pin)
        return balance
    }

    private fun checkPin(pin: String) {
        if (pin != this.myPin) throw Exception("Ошибка pin")
    }


}

fun main() {
    val account = Account(0.0)

}