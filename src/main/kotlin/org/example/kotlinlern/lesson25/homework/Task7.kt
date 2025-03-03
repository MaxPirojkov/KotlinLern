package org.example.kotlinlern.lesson25.homework

/*

Задание 7. Создай функцию расширения словаря из списка и множества
, которая принимает все известные тебе типы
(вспомни все что знаешь и под каждый тип создай аргумент)
и возвращает строку.
Функция должна распечатать все данные,
которые тебе в ней доступны
и вернуть конкатенацию всех данных которые ей доступны (порядок неважен).
Конкатенация - это присоединение.
Код должен быть отформатирован таким образом, чтобы легко читался.
По аналогии с предыдущим заданием выполни трансформации.
 */

fun main() {
    val myMap: Map<List<*>, Set<*>> = mapOf(
        listOf("one", "two", "three") to setOf(1, 2, 3),
        listOf("four", "five", "six") to setOf(4, 5, 6)
    )
    val mylist = listOf(1, 2, 4, 5)
    val mySet = setOf("one", "two", "three")
    val newMap = mapOf(1 to 1, 2 to 2, 3 to 3)


    val function71 =
        fun Map<List<*>, Set<*>>. (
            str: String,
            numb: Int,
            long: Long,
            byte: Byte,
            double: Double,
            char: Char,
            float: Float,
            boolean: Boolean,
            pair: Pair<String, Int>,
            list: List<*>,
            set: Set<*>,
            map: Map<*, *>
        ): String {
            val result = listOf(
                this.toString(),
                str,
                numb.toString(),
                long.toString(),
                byte.toString(),
                double.toString(),
                char.toString(),
                float.toString(),
                boolean.toString(),
                pair.toString(),
                list.toString(),
                set.toString(),
                map.toString()
            )
            return result.joinToString(" , ")
        }


    println(
        myMap.function7(
            "1",
            3,
            1002020202020,
            12,
            3.4,
            'b',
            43F,
            true,
            "one" to 1,
            mylist,
            mySet,
            newMap
        )
    )

    val function72: Map<List<*>, Set<*>>.(
        String,
        Int,
        Long,
        Byte,
        Double,
        Char,
        Float,
        Boolean,
        Pair<String, Int>,
        List<*>,
        Set<*>,
        Map<*, *>
    ) -> String = { str: String,
                    numb: Int,
                    long: Long,
                    byte: Byte,
                    double: Double,
                    char: Char,
                    float: Float,
                    boolean: Boolean,
                    pair: Pair<String, Int>,
                    list: List<*>,
                    set: Set<*>,
                    map: Map<*, *> ->

        val result = listOf(
            this.toString(),
            str,
            numb.toString(),
            long.toString(),
            byte.toString(),
            double.toString(),
            char.toString(),
            float.toString(),
            boolean.toString(),
            pair.toString(),
            list.toString(),
            set.toString(),
            map.toString()
        )
        result.joinToString(" , ")
    }
}

fun Map<List<*>, Set<*>>.function7(
    str: String,
    numb: Int,
    long: Long,
    byte: Byte,
    double: Double,
    char: Char,
    float: Float,
    boolean: Boolean,
    pair: Pair<String, Int>,
    list: List<*>,
    set: Set<*>,
    map: Map<*, *>
): String {
    val result = listOf(
        this.toString(),
        str,
        numb.toString(),
        long.toString(),
        byte.toString(),
        double.toString(),
        char.toString(),
        float.toString(),
        boolean.toString(),
        pair.toString(),
        list.toString(),
        set.toString(),
        map.toString()
    )
    return result.joinToString(" , ")
}