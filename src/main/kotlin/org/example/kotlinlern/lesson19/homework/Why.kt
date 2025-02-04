package org.example.kotlinlern.lesson19.homework

abstract class BaseClass(
    // ✅ объясни, почему это поле доступно в main() для чтения из класса ChildrenClass - в ChildrenClass создали новое поле val privateVal и оно относится только к ChildrenClass
    private val privateVal: String,
    // ✅ объясни, почему это поле недоступно в main() оно protected и к нему напрямую нельзя обратиться
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "измени меня из функции main() через сеттер в наследнике"
    private var privateField = "добавь сеттер чтобы изменить меня из main()"

    fun setPrivateField(string: String){
        privateField = string
    }

    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to publicField,
            "protectedField" to protectedField,
            "privateField" to privateField,
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }

    fun printText() {
        privatePrint()
    }

    // ✅объясни, почему эта функция не может быть публичной - протектед ProtectedClass - функция наследуется с модификатором доступ не будет мейн
    protected open fun getProtectedClass() = ProtectedClass()

    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }

    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }

    // ✅ объясни, почему эта функция не может быть публичной или protected - потому что класс от которого функция наследуется приватный и доступен в рамках файла и функция не сможет вернуть данные
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass

    private class PrivateClass
}

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле - потому что он публичный и наследуемся от Base class
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    // ✅ объясни, почему в main() доступна функция getAll() хотя её здесь нет - отнаследовались от BAse класса, fun getAll с публичным модификатором

    // проверь, что выводится на печать при вызове функции printText() печать из base class
    // и объясни, почему не происходит переопределение метода privatePrint()
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun verifyPublicField(value: String): Boolean {
        return value.length > 3
    }

    fun setProtectedField1(value: String) {
        protectedField = value
    }

}

