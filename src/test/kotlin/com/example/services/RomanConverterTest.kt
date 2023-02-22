package com.example.services

import kotlin.test.Test
import kotlin.test.assertEquals

class RomanConverterTest {

    @Test
    fun roman2arabic() {
        val parameters = listOf(
            "I" to 1,
            "II" to 2,
            "III" to 3,
            "V" to 5,
            "X" to 10,
            "XV" to 15,
            "VI" to 6,
            "IV" to 4,
            "MCMLXXXV" to 1985,
        )

        parameters.forEach { (romanNum, expected) ->
            val calculated = com.example.services.roman2arabic(romanNum)
            assertEquals(expected, calculated)

        }

    }
}


