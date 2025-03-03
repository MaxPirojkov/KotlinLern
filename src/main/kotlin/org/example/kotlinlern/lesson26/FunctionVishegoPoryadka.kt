package org.example.kotlinlern.lesson26

// функции высшего порядка - это функции которые принимают другие функции в качестве аргументов


fun processWebData(
    query: String,
    fetcher: (String) -> List<Map<String, Any>>,
    transformer: (List<Map<String, Any>>) -> List<User>,
    displayer: (List<User>)-> Unit
) {
    val rawData = fetcher(query)
    val transformerData = transformer(rawData)
    displayer(transformerData)
}

data class User(val name: String)

fun main() {
    val fetcher: (String) -> List<Map<String, Any>> = {
        // orm.select(it).map { listOf() }
        listOf(mapOf("Andrey" to "5"))
    }

    val transformer: (List<Map<String, Any>>) -> List<User> = {
        it.map { map -> User(map.keys.first()) }
    }

    val displayer: (List<User>) -> Unit = {
        println(it)
    }

    processWebData("sql query", fetcher, transformer, displayer)
}