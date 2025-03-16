package org.example.kotlinlern.lesson28.homework.additional

class EncryptorImpl(private val encr: Int) : Encryptor {
    override fun encrypt(content: String): String {
            return content.map { it + encr }.joinToString("")
        }
}

