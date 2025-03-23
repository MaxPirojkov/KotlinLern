package org.example.kotlinlern.lesson27.homework

/*
Задание 1. Функция высшего порядка.

Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
Функция timeTracker должна возвращать затраченное время в миллисекундах.
Для измерения времени используйте System.currentTimeMillis() до и после выполнения переданной функции.

Для проверки результата можно выполнить в ней например такой ресурсоёмкий код:
 */

fun main() {
//task1
    fun timeTracker(arg: () -> Any): Long {
        val start = System.currentTimeMillis()
        arg()
        val finish = System.currentTimeMillis()
        return finish - start
    }

    val myFunction = {
        val list = List(10000000) { (0..10000).random() }
        list.sorted()
    }

    val time = timeTracker(myFunction)
    println(time)


    /*
Задание 2: Использование apply для инициализации объекта Employee
Создайте объект Employee и используйте apply для инициализации его полей email и department.
*/
    val task2 = Employee(
        "Ivan",
        31,
        "Manager"
    ).apply {
        email = "ivan@mail.ru"
        department = "logistics"
    }

    /*
    Задание 3: Использование also для логирования
    Создайте функцию, принимающую объект Person
    и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
    Создайте объект Person и используйте also для печати данных в консоль с помощью метода который только что создали.
*/
    val task3 = Person("Mark", 33)
    task3.email = "Mark@mail.ru"
    task3.also {
        logPerson(it)
    }

    /*
    Задание 4: Использование with для преобразование Person в Employee
    Создайте объект класса Person.
    Используйте функцию with,
    чтобы создать из этого объекта Employee,
    указав дополнительно должность.
    Возвращаемым значением должен быть новый объект Employee.
     */

    val task4 = Person("Petr", 40)
    val task41 = with(task4) {
        Employee(
            name,
            age,
            "CEO"
        )
    }

    println(task41.name + " " + task41.age)

    /*
    Задание 5: Использование run для преобразования и инициализации Employee
    Создайте объект класса Person.
    Используйте функцию run,
    чтобы инициализировать объект Employee,
    добавить ему email и department с помощью apply,
    вернуть инициализированный объект.
     */

    val task5 = Person("George", 30).run {
        Employee(name, age, "Manager").apply {
            email = "manager@mail.ru"
            department = "top"
        }
    }

    /*
    Задание 6: Использование let для безопасного преобразования Person в Employee
    Создайте функцию, которая принимает объект класса Person?,
    который может быть null.
    В функции используйте функцию let для создания Employee,
    только если объект Person не null. В противном случае возвращается null
     */

    val task6 = Person("Michel", 65)
    val task61 = transform(null)
    println(task61?.name + " " + task61?.age  )
}

fun transform(person: Person?): Employee? {
    return person?.let {
        Employee(it.name, it.age, "manager")
    }
}

fun logPerson(person: Person) {
    println("Person name is ${person.name} \n${person.age} years old \nemail is ${person.email}")
}