package com.example.usecase10

import com.example.usecase10.StringUtils.isValid
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testValidString() {
        val input = "Aa1!"
        assertTrue("String should be valid.", isValid(input, 10))
    }

    @Test
    fun testNoUppercase() {
        val input = "aa1!"
        assertFalse("String should be invalid as it doesn't contain an uppercase letter.", isValid(input, 10))
    }

    @Test
    fun testNoLowercase() {
        val input = "AA1!"
        assertFalse("String should be invalid as it doesn't contain a lowercase letter.", isValid(input, 10))
    }

    @Test
    fun testNoDigit() {
        val input = "Aa!!"
        assertFalse("String should be invalid as it doesn't contain a digit.", isValid(input, 10))
    }

    @Test
    fun testNoSpecialChar() {
        val input = "Aa11"
        assertFalse("String should be invalid as it doesn't contain a special character.", isValid(input, 10))
    }

    @Test
    fun testContainsWhitespace() {
        val input = "Aa 1!"
        assertFalse("String should be invalid as it contains whitespace.", isValid(input, 10))
    }

    @Test
    fun testMaxLengthExceeded() {
        val input = "Aa1!Aa1!Aa1"
        assertFalse("String should be invalid as it exceeds max length.", isValid(input, 10))
    }

    @Test
    fun testExactlyAtMaxLength() {
        val input = "Aa1!Aa1!Aa"
        assertTrue("String should be valid as it's exactly at the max length.", isValid(input, 10))
    }

    @Test
    fun testSpecialCharacters() {
        val input = "Aa1@#$%^&*"
        assertTrue("String should be valid with various special characters.", isValid(input, 10))
    }

    @Test
    fun testEdgeCaseEmptyString() {
        val input = ""
        assertFalse("String should be invalid as it's empty.", isValid(input, 10))
    }

    @Test
    fun testContainsVariousWhitespaceCharacters() {
        val spaceInput = "Aa1 !"
        val tabInput = "Aa1!\t"
        val newlineInput = "Aa1!\n"

        assertFalse("String should be invalid as it contains a space.", isValid(spaceInput, 10))
        assertFalse("String should be invalid as it contains a tab.", isValid(tabInput, 10))
        assertFalse("String should be invalid as it contains a newline.", isValid(newlineInput, 10))
    }
}