package org.example.kotlinlern.lesson17.homework.materials

class FirstClass() : Materials() {
    fun addToBottom(str: String) {
        val listMaterials = extractMaterial() // список из materials передался и очистился
        addMaterial(str) // список был пуст, добавили под индексом 0 new string
        listMaterials.forEach { addMaterial(it) } // добавили из listMaterials содержимое списка
    }
}

class SecondClass : Materials() {
    fun evenNumb(newList: List<String>) {
        val list = extractMaterial()
        val maxSize = maxOf(list.size, newList.size) // вычисляем максимальный размер листа
        for (i in 0 until maxSize) {     // запускаем цикл с ограничением в макс размер, что б не получить out of range
            if (i < newList.size) {
                addMaterial(newList[i])        //добавляем в list material один элемент из одного списка
            }
            if (i < list.size) {
                addMaterial(list[i])         // //добавляем в list material один элемент из другого списка
            }
        }
    }
}

/*
Третий класс должен добавлять элементы в список в алфавитном порядке.
Если мы добавляем новый элемент в список,
то он должен встать где-то между другими элементами
и занять место в соответствии с сортировкой по алфавиту.


 */
class ThirdClass : Materials() {
    fun addElement(str: String) {
        val list = extractMaterial().toMutableList()
        list.add(str)
        list.sort()
        list.forEach { addMaterial(it) }
    }
}

/*
Четвёртый класс должен принимать словарь из строк (ключи и значения).
Каждая пара ключа и значения должна попадать в контейнер
следующим образом - ключ в начало, значение в конец.
 */

class ForthClass : Materials() {
    fun filterMap(map: Map<String, String>) {
        val list = extractMaterial().toMutableList()
        map.forEach { (key, value) ->
            list.add(0, key)
            list.add(value)
        }
        list.forEach { addMaterial(it) }
    }
}