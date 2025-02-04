package org.example.kotlinlern.lesson19.homework.calc

abstract class Operations(
    private val operator: String
) {

    abstract fun operate(expression: String): String

    fun checkOperator(expression: String): Boolean {
        return expression.contains(operator)
    }

    protected fun splitOperandsToDouble(expression: String): List<Double> {
        val operands = splitOperands(expression)
        return operands.map { it.toDouble() }
    }

    protected fun splitOperands(expression: String): List<String> {
        val operands = expression.split(operator).map {it.trim()}
        if (operands.size != 2) throw IllegalArgumentException("Ожидается два операнда, но получено ${operands.size}")
        return operands
    }
}