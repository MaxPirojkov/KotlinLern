package org.example.kotlinlern.lesson31

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.example.kotlinlern.lesson30.homework.CharacterTypes
import java.io.File

/*
Создай дата класс сотрудника компании Employee, содержащий:
имя
статус трудоустройства (булево)
дата рождения (строка)
должность CharacterTypes (enum из прошлого урока)
список подчинённых с типом Employee

Создай небольшую иерархию из сотрудников где во главе CTO.
Это значит что в объект сотрудника с должностью CTO
в поле списка подчинённых должны попасть пара тим лидов,
в списке подчинённых которых есть разработчики, дизайнеры и тестировщики. Чтобы было немного но и была вложенность.

Сериализуй CTO в текст с настройкой prettyPrinting и текст запиши в файл в корне проекта.

Прочитай текст из файла, десериализуй его в объект класса Employee и распечатай в консоль.

 */

data class Employee (
    val name: String,
    val statusWork: Boolean,
    val birthDay: String,
    val position: CharacterTypes,
    val subordinatesList: List<Employee>?
)

val qa1 = Employee(
    "Ku A",
    true,
    "07.01.1990",
     CharacterTypes.QA,
    null)
val qa2 = Employee(
    "Que Ay",
    true,
    "02.02.1980",
    CharacterTypes.QA,
    null
)

val developer1 = Employee(
    "Dev Loper",
    true,
    "09.09.1999",
    CharacterTypes.BACKEND_DEV,
    null
)
val developer2 = Employee(
    "Devel Poper",
    true,
    "10.02.1950",
    CharacterTypes.GAME_DEV,
    null
)

val designer = Employee(
    "De Zigner",
    true,
    "01.01.2000",
    CharacterTypes.UX_UI,
    null
)

val teamLead1 = Employee(
    "Tim Lidov",
    true,
    "02.02.1990",
    CharacterTypes.TEAM_LEAD,
    listOf(designer, developer2, qa1)
)
val teamLead2 = Employee(
    "Tim Lidovskiy",
    true,
    "03.03.1993",
    CharacterTypes.TEAM_LEAD,
    listOf(developer1, qa2)
)

val cto: Employee = Employee(
    "Tony Stark",
    true,
    "10.10.1970",
    CharacterTypes.CTO,
    listOf(teamLead1, teamLead2))


fun main() {
    val gson = GsonBuilder()
        .setPrettyPrinting()
        .serializeNulls()
        .create()

    val json = gson.toJson(cto)

    val file = File( "json/cto.json")
    file.parentFile.mkdirs()
    file.createNewFile()
    file.writeText(json)
    val revert = gson.fromJson(file.readText(), Employee::class.java)
    println(revert) // Employee(name=Tony Stark, statusWork=true, birthDay=10.10.1970, position=CTO, subordinatesList=[Employee(name=Tim Lidov, statusWork=true, birthDay=02.02.1990, position=TEAM_LEAD, subordinatesList=[Employee(name=De Zigner, statusWork=true, birthDay=01.01.2000, position=UX_UI, subordinatesList=null), Employee(name=Devel Poper, statusWork=true, birthDay=10.02.1950, position=GAME_DEV, subordinatesList=null), Employee(name=Ku A, statusWork=true, birthDay=07.01.1990, position=QA, subordinatesList=null)]), Employee(name=Tim Lidovskiy, statusWork=true, birthDay=03.03.1993, position=TEAM_LEAD, subordinatesList=[Employee(name=Dev Loper, statusWork=true, birthDay=09.09.1999, position=BACKEND_DEV, subordinatesList=null), Employee(name=Que Ay, statusWork=true, birthDay=02.02.1980, position=QA, subordinatesList=null)])])
}