package org.example.kotlinlern.lesson20.homework.firsttask

import org.example.kotlinlern.lesson20.homework.*

abstract class WashingMachine : Powerable, Openable, WaterContainer, TemperatureRegulatable, AutomaticShutdown,
    Drainable, Timable, Programmable, Cleanable {
}