package org.example.kotlinlern.lesson18.homework21

import org.example.kotlinlern.lesson18.homework.Background
import org.example.kotlinlern.lesson18.homework.Colors
import org.example.kotlinlern.lesson18.printColored

const val INFO = "INFO"
const val WARNING = "WARNING"
const val ERROR = "ERROR"
const val DEBUG = "DEBUG"

class Logger {
    fun log(message: String) {
        println("$INFO: $message")
    }

    fun log(levelLog: String, message: String) {
        if (levelLog == WARNING) {
            printColored(message, Colors.YELLOW, Background.BG_BLUE)
        } else if (levelLog == ERROR) {
            printColored(message, Colors.WHITE, Background.BG_RED)
        } else {
            println("$levelLog: $message")
        }
    }

    fun log(list: List<String>) {
        for (i in list) {
            println("$INFO: $i")
        }
    }

    fun log(exp: Exception) {
        println("$ERROR: ${exp.message}")
    }
}


fun main() {
    val message = "System initialized successfully."
    val list = listOf(
        "System initialized successfully.",
        "Low disk space on drive C.",
        "Failed to connect to the database.",
        "User input validation passed.",
    )

    val myLog = Logger()
    // myLog.log(message)
    // myLog.log(WARNING, message)
    // myLog.log(ERROR, message)
    // myLog.log(DEBUG, message)
    // myLog.log(list)

    try {
        throw Exception("Что то пошло не так")
    } catch (e: Exception) {
        myLog.log(e)
    }
}