package org.example.kotlinlern.lesson20.homework.firsttask

import org.example.kotlinlern.lesson20.homework.Mechanical
import org.example.kotlinlern.lesson20.homework.Openable
import org.example.kotlinlern.lesson20.homework.Programmable
import org.example.kotlinlern.lesson20.homework.Timable

abstract class MechanicalWatches : Openable, Timable, Mechanical, Programmable {
}