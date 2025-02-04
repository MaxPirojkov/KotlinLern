package org.example.kotlinlern.lesson20.homework.firsttask

import org.example.kotlinlern.lesson20.homework.Openable
import org.example.kotlinlern.lesson20.homework.Powerable
import org.example.kotlinlern.lesson20.homework.Programmable
import org.example.kotlinlern.lesson20.homework.TemperatureRegulatable

abstract class Fridge : Powerable, Openable, TemperatureRegulatable, Programmable {
}