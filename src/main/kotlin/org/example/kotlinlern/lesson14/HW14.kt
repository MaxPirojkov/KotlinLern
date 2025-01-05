package org.example.kotlinlern.lesson14

fun main() {

    /*
    Для решения каждой задачи постарайтесь использовать наиболее подходящий метод, не повторяясь с решением других задач.

    1. Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
    */
    val averageTime = mapOf<String, Int>()
    averageTime.values.average()

    /*
    2. Имеется словарь с метаданными автоматизированных тестов,
    где ключи — это имена тестовых методов а значения - строка с метаданными.
    Выведите список всех тестовых методов.
     */
    val nameOfTests =
        mapOf<String, String>("1" to "Failed", "2 optional" to "Success", "3" to "Sciped", "3 optional" to "Failed")
    val listOfTests = mutableListOf<String>()
    nameOfTests.map { listOfTests.add(it.key) }
    /*
    3. В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    */
    val testResult = mutableMapOf<Int, String>()
    testResult.putAll(mapOf())
    /*
    4. Посчитайте количество успешных тестов в словаре с результатами.
    */
    val filteredByPrice = testResult.filter { it.value == "Success" }
    filteredByPrice.size

    /*
    5. Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен.
    */
    val mutableMap = mutableMapOf<String, String>()
    mutableMap.remove("crash Main activity")
    /*
    6. Для словаря с результатами тестирования веб-страниц
    (ключ — URL страницы, значение — статус ответа),
    выведите сообщение о странице и статусе её проверки.
    */
    val testResult1 = mapOf<String, Int>("http://url1" to 200, "http://url2" to 300, "http://url3" to 200)
    for (entry in testResult1.entries) {
        println("Page with url - ${entry.key}, ${entry.value} - статус ответа")
    }

    /*
    7. Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    */
    val timeOfResponse = mapOf<String, Int>()
    val timeOutResponse = timeOfResponse.filterValues { it > 15 }

    /*
    8. В словаре хранятся результаты тестирования API
    (ключ — endpoint, значение — статус ответа в строке).
    Для указанного endpoint найдите статус ответа,
    если endpoint отсутствует, предположите, что он не был протестирован.
    */
    val testResultApi = mapOf<String, String>()
    println(testResultApi.getOrElse("/services") { throw Exception("not allowed") })
    /*
    9. Из словаря, содержащего конфигурации тестового окружения
    (ключ — название параметра конфигурации),
    получите значение для "browserType". Ответ не может быть null.
    */
    val configTest = mapOf<String, String>()
    configTest.getValue("browserType")
    /*
    10. Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, чтобы добавить новую версию.
    */
    val versionOS = mapOf<Int, String>()
    val copyOfVersion = versionOS + (1.1 to "Release candidate")
    /*
    11. Используя словарь с настройками тестирования для различных мобильных устройств
    (ключ — модель устройства),
    получите настройки для конкретной модели или верните настройки по умолчанию.
    */
    val mobileDevices = mapOf<String, String>()
    println(mobileDevices.getOrElse("Pixel 6") { "Default Settings" })
    /*
    12. Проверьте, содержит ли словарь с ошибками тестирования (код и описание) определенный код ошибки.
    */
    val testError = mapOf<Int, String>()
    testError.contains(303)
    /*

    13. Дан неизменяемый словарь, НЕ РЕШИЛ
    где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version",
    а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped").
    Отфильтруйте словарь, оставив только те сценарии,
    и   дентификаторы которых соответствуют определённой версии тестов.
    */
    val resultOfRegress = mapOf<String, String>()
    resultOfRegress.filter { it.key == "TestID_Version" }
    /*
    14. У вас есть словарь,
    где ключи — это названия функциональных модулей приложения,
    а значения — результаты их тестирования.
    Проверьте, есть ли модули с неудачным тестированием.
    */
    val functionModuleApp = mapOf<String, String>()
    val failedModel = functionModuleApp.filterValues { it == "failed" }
    /*
    15. Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    */
    val mutableSettingsDeviceMap: MutableMap<String, String> = mobileDevices.toMutableMap()

    /*
    16. Объедините два неизменяемых словаря с данными о багах.
    */
    val firstMap = mapOf<Int, String>()
    val secondMap = mapOf<Int, String>()
    val thirdMap = firstMap + secondMap

    /*
    17. Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
    */
    val resultOfRun = mutableMapOf<String, Int>()
    resultOfRun.clear()
    /*
    18. Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”)
    */
    val mutableMapTestRun = mutableMapOf<Int, String>(100 to "Passed", 101 to "Skipped", 102 to "Failed")
    println(mutableMapTestRun.filterNot { it.value == "Skipped" })

    /*
    19. Удалите из словаря с конфигурациями тестирования набор устаревших конфигураций.
    НЕ решил
    не оч понял что значит устаревшие

    20. Создайте отчет о тестировании,
    преобразовав словарь с результатами тестирования
    (ключ — идентификатор теста, значение — результат)
    в список строк формата "Test ID: результат".
    */
    val mapReport = mapOf(100 to "Success", 101 to "Failed")
    val listReport = mutableListOf<String>()
    for (entries in mapReport.entries) {
        listReport += "${entries.key} : ${entries.value}"
    }
    /*

    21. Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
    */
    val testRes1 = mutableMapOf<Int, String>()
    val archiveTestRes = testRes1.toMap()
    /*
    22. Преобразуйте словарь,
    содержащий ID теста и данные о времени выполнения тестов,
    заменив идентификаторы тестов на их названия
    (название можно получить вызвав фейковый метод,
    например getNameById(id: String))
    */


    /*
    23. Для словаря с оценками производительности различных версий приложения
    увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
     */
    val performanceApp = mutableMapOf<Int, Int>(1 to 100, 2 to 50)
    val increaseMark = performanceApp.mapValues { (it.value * 0.1) + it.value }

    /*
        24. Проверьте, пуст ли словарь с ошибками компиляции тестов.
        */
    testError.isEmpty()
    /*
    25. Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
    */
    testResult.isNotEmpty()
    /*
        26. Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
        */
    testResult.all { it.value == "Success" }
    /*
            27. Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
    */
    testResult.any { it.value == "Failed" }
    /*
        28. Отфильтруйте словарь с результатами тестирования сервисов,
        оставив только те тесты,
        которые не прошли успешно и содержат в названии “optional”.
        */
    nameOfTests.filter { it.value == "Failed" && it.key.contains("optional") }
}

fun getNameById(id: String) {

}