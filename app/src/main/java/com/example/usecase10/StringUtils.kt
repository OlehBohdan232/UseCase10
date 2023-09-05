package com.example.usecase10

object StringUtils {
    const val ONE_UPPERCASE = """(?=.*[A-Z])"""
    const val ONE_LOWERCASE = """(?=.*[a-z])"""
    const val ONE_DIGIT = """(?=.*\d)"""
    const val ONE_SPECIAL_CHAR = """(?=.*[!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~])"""
    const val NO_WHITESPACE = """(?![\s\t\n\r])"""

    fun isValid(input: String, maxLength: Int): Boolean {
        // Ensure string is at most 'maxLength' characters
        val lengthCheck = """.{1,$maxLength}"""

        // Compile the full pattern
        val pattern = """^$ONE_UPPERCASE$ONE_LOWERCASE$ONE_DIGIT$ONE_SPECIAL_CHAR$NO_WHITESPACE$lengthCheck$""".toRegex()

        return pattern.matches(input)
    }
}