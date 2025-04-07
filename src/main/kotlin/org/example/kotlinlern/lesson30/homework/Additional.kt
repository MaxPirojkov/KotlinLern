package org.example.kotlinlern.lesson30.homework

fun main() {
   // trafficLight()
    coffeeVariant(CharacterTypes.CTO).description()  //The Espresso without milk costs $2.5 and is best with 0 spoons of sugar.
    coffeeVariant(CharacterTypes.QA).description() //The Nescafe classic without milk costs $2.0 and is best with 0 spoons of sugar.
}

/*
Дополнительное задание 1 Светофор
Создай enum с перечислением для светофора.
Enum должен включать цвет из класса Colors,
длительность сигнала duration и количество миганий blinkTimes (может быть null).
Мигание нужно установить только для зелёного сигнала.
Реализовать функцию с бесконечным циклом,
которая будет выводить сигналы светофора в порядке:
красный (4 сек), жёлтый (2 сек), зелёный (4 сек), зелёный мигающий (4 раза).
Отображение сигнала выполняется через showSignal()
Задержку между сигналами можно выполнить через Thread.sleep()
в который передаётся задержка в миллисекундах.
Мигание выполняется через попеременный вызов clear() и showSignal() с задержками между ними в 300мс
 */

enum class Colors(val value: String) {
    RED_COLOR("\u001B[31m"),
    YELLOW_COLOR("\u001B[33m"),
    GREEN_COLOR("\u001B[32m"),
    RESET_COLOR("\u001B[0m")
}

const val LIGHT_SYMBOL = "\u25CF"

enum class TrafficLightSignal(
    val color: Colors,
    val duration: Int,
    val blinkTimes: Int?) {
    RED(Colors.RED_COLOR,4000, null),
    YELLOW(Colors.YELLOW_COLOR,2000, null),
    GREEN(Colors.GREEN_COLOR,4000, null),
    GREEN_BLINK(Colors.GREEN_COLOR,300, 4)
}

fun trafficLight() {
    while (true) {
        for (i in TrafficLightSignal.entries) {
            if (i.blinkTimes == null) {
                showSignal(i)
                Thread.sleep(i.duration.toLong())
                clear()
            } else {
                repeat(i.blinkTimes) {
                    showSignal(i)
                    Thread.sleep(i.duration.toLong())
                    clear()
                    Thread.sleep(i.duration.toLong())
                }
            }
        }
    }
}


fun showSignal(signal: TrafficLightSignal) {
    print("\r" + signal.color.value + LIGHT_SYMBOL + Colors.RESET_COLOR.value)
}

fun clear() {
    print("\r    ")
}

/*
Дополнительное задание 2
Заготовки для задачи
Напиши функцию, которая определит,
какой тип кофе предложить посетителю исходя из его функциональной принадлежности.

Эспрессо - СТО или тимлид
Латте - дизайнер и геймдев
Капучино - Менеджеры
Американо - бэкендеры и сисадмины
Для QA добавь в enum ещё один вид напитка: Nescafe classic

Реши задачу через доработку enum CharacterTypes
 */

enum class CoffeeType(val cost: Double, val coffeeBase: String, val recommendedSugar: Int, val hasMilk: Boolean = false) {
    ESPRESSO(2.50, "Espresso", 0),
    LATTE(3.00, "Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.25, "Americano", 0),
    NESCAFE_CLASSIC(2.00, "Nescafe classic", 0),
    ;

    fun description() = println("The $coffeeBase ${if (this.hasMilk) "with" else "without"} milk costs \$${this.cost} and is best with ${this.recommendedSugar} spoons of sugar.")
}

enum class CharacterTypes(val favCoffee: CoffeeType) {
    CTO(CoffeeType.ESPRESSO),
    UX_UI(CoffeeType.LATTE),
    CRM(CoffeeType.CAPPUCCINO), // Customer Relationship Manager
    GAME_DEV(CoffeeType.LATTE),
    TEAM_LEAD(CoffeeType.ESPRESSO),
    BACKEND_DEV(CoffeeType.AMERICANO),
    PM(CoffeeType.CAPPUCCINO),
    SYSADMIN(CoffeeType.AMERICANO),
    QA(CoffeeType.NESCAFE_CLASSIC)
}

fun coffeeVariant(type: CharacterTypes) = type.favCoffee


