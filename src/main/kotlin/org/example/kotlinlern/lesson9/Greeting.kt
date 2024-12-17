package org.example.kotlinlern.lesson9

fun main() {
    greet(30, 12)
}

fun greet(day: Int, month: Int) {
    var count = 0
    val christmas = """ 
    |,\/,| |[_' |[_]) |[_]) \\//
    ||\/|| |[_, ||'\, ||'\,  ||
    ___ __ __ ____  __  __  ____  _  _    __    __
    // ' |[_]| |[_]) || ((_' '||' |,\/,|  //\\  ((_'
    \\_, |[']| ||'\, || ,_))  ||  ||\/|| //``\\ ,_))
    """.trimIndent()

    val other = """
               .''.      .        *''*    :_\/_:     . 
      :_\/_:   _\(/_  .:.*_\/_*   : /\ :  .'.:.'.
  .''.: /\ :   ./)\   ':'* /\ * :  '..'.  -=:o:=-
 :_\/_:'.:::.    ' *''*    * '.\'/.' _\(/_'.':'.'
 : /\ : :::::     *_\/_*     -= o =-  /)\    '  *
  '..'  ':::'     * /\ *     .'/.\'.   '
      *            *..*         :
       *
        *""".trimIndent()

    if (day == 31 && month == 12) {
        println(christmas)
    } else {
        println("Happy holliday 💫 \n$other")
    }
}