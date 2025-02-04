package org.example.kotlinlern.lesson19.homework

open class GameMachine(
    val color: String,
    val model: String,
    private var isOn: Boolean,
    private var isLoadOS: Boolean,
    private val listOfAvailableGames: List<String>,
    val isControllerAvailable: Boolean,
    private var balance: Int,
    private var owner: String,
    private var supportNumber: Int
) {
    fun turnOn() {
        isOn = true
        loadOS()
    }

    fun turnOf() {
        turnOffOS()
        isOn = false
    }

    private fun loadOS() {
        isLoadOS = true
    }

    private fun turnOffOS() {
        isLoadOS = false
    }

    fun displayListOfGame() {
        println(listOfAvailableGames)
    }

    fun turnOnGame(gameName: String) {
        println("запуск игры $gameName")
    }

    fun payForTime(money: Int) {
        balance += money
    }

    fun cash(money: Int, pin: Int) {
        balance -= money
    }

    protected fun payTheWinings() {}

}