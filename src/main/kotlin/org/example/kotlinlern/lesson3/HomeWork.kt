package org.example.kotlinlern.lesson3

//Название меороприятия
const val EVENT_NAME = "Hackathon Survival"

//Дата проведения
const val EVENT_DATE = "12 dec 2024"

//Место проведения
const val EVENT_PLACE = "Las Vegas, Grand Hotel"

//Подробный бюджет мероприятия, включая расходы на оборудование,
// кейтеринг и другие операционные расходы.
val eventBudgetDetails: String by lazy{
    ""
}

//Количество участников
var numberOfParticipants: Int = 0

//Длительность хакатона (мин)
var eventDuration: Int = 300

//Контактная информация и условия соглашений с поставщиками пищи,
//оборудования и других услуг.
val contactList: String by lazy{
    ""
}

//Текущее состояние хакатона (статус)
var eventStatus: String = "In progress"

//Текущее состояние хакатона (статус)
// Будет удобно использовать
const val STATUS_TO_DO = "To Do"
const val STATUS_IN_PROGRESS = "In Progress"
const val STATUS_OPEN = "Open"
const val STATUS_FINISH = "Finish"
const val STATUS_CLOSED = "Closed"

//Список спонсоров
var sponsorList: String = ""

//Бюджет мероприятия
var eventBudget: Int = 1_000_000

//Current Internet access level
var internetAccessLeve: String = "Allow"

//Информация о транспортировке оборудования,
// распределении ресурсов и координации между различными командами поддержки.
val resourceSupportInformation: String by lazy{
    ""
}

//Количество команд
var teamNumbers: Int = 25

//Перечень задач
var taskList: String = ""

