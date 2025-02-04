package org.example.kotlinlern.lesson19.homework.calc

class Сalculator(customOperations: List<Operations>) { //принимает список кастомных обработчиков в конструкторе
    // хранит в приватном поле список стандартных обработчиков
    // и добавленный к нему список кастомных.
    // Мы будем перебирать этот список и находить нужный обработчик при вычислении выражения.
    private val operations = customOperations + listOf(
        SumOperations(),
        MultiplicationOperations(),
        DiffOperations(),
        DivOperations(),
        DivReminderOperations(),
        )

    fun operate(expression: String): String {
        return getExecutor(expression).operate(expression)
        //Метод должен перебрать все подключенные обработчики
        // и найти подходящий для вычисления выражения.
    }

    private fun getExecutor(expression: String): Operations {
        return operations.find { it.checkOperator(expression) } ?: throw Exception("Не найден исполнитель")
    }

    /*
    В этом же файле можно хранить набор приватных классов-обработчиков,
    наследованных от Operations.
    Это классы для сложения, вычитания, умножения и деления чисел,
    а также вычисления остатка от деления.
    Так как эти классы нужны только для калькулятора
    и больше нигде использоваться не должны, они должны быть приватными.
     */

    private class SumOperations : Operations("+") {

        override fun operate(expression: String): String {
            return splitOperandsToDouble(expression).sum().toString()
        }
    }

    private class MultiplicationOperations : Operations("*") {

        override fun operate(expression: String): String {
            val operands = splitOperandsToDouble(expression)
            val result = operands[0] * operands[1]
            return result.toString()
        }
    }

    private class DiffOperations : Operations("-") {

        override fun operate(expression: String): String {
            val operands = splitOperandsToDouble(expression)
            val result = operands[0] - operands[1]
            return result.toString()
        }
    }

    private class DivOperations : Operations("/") {

        override fun operate(expression: String): String {
            val operands = splitOperandsToDouble(expression)
            if (operands[1] == 0.0) throw IllegalArgumentException("Нельзя делить на ноль")
            val result = operands[0] / operands[1]
            return result.toString()
        }
    }

    private class DivReminderOperations : Operations("%") {

        override fun operate(expression: String): String {
            val operands = splitOperandsToDouble(expression)
            val result = operands[0] % operands[1]
            return result.toString()
        }
    }
}