package org.example.kotlinlern.lesson20.homework.firsttask

import org.example.kotlinlern.lesson20.homework.*

abstract class SmartLamp : Powerable, TemperatureRegulatable, AutomaticShutdown, Timable, BatteryOperated,
    LightEmitting, SoundEmitting, Programmable {
}