package org.example.kotlinlern.lesson30

fun main() {
    Seasons.AUTUMN.printInfo()
    Seasons.WINTER.printInfo()

    println( Seasons.detectSeason("March") )

    HomeDevices.FRIDGE.action()
    HomeDevices.WASHER.action()
    HomeDevices.TV.action()
}

enum class Seasons(val firstMonthName: String, val isVolatileDuration: Boolean ) {
    WINTER( "December", true),
    SPRING( "March", false),
    SUMMER("June", false),
    AUTUMN("September", false),
    ;

    fun printInfo() {
        println("in $this first month ${this.firstMonthName} season ${if(isVolatileDuration) "is volatile" else "is not volatile"} duration")
    }

    companion object {
        fun detectSeason(month: String): Seasons? {
                return Seasons.entries.firstOrNull { month == it.firstMonthName } ?: throw IllegalArgumentException()
        }
    }
}

interface HasValue {
    val value: String
}

interface HasAction {
    fun action()
}

enum class HomeDevices(override val value: String): HasValue, HasAction {
    TV ("телевизор"),
    FRIDGE("холодильник") {
        override fun action() {
            println("Freeze")
        }
    },
    WASHER ("Стиральная машина") {
        override fun action() {
            println("wash")
        }
    },
    ;

    override fun action() {
        println("turn on $value")
    }

}