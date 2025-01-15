package org.example.kotlinlern.lesson15.homework

object Moon {
    var isVisible = true
    var phase = "Full Moon"  //"New Moon"

    fun showPhase(){
        if (isVisible){
            println("Current phase - $phase")
        } else {
            "Moon is not visible"
        }
    }
}