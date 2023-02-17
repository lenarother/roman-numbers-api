package com.example.services

import kotlin.math.abs


fun roman2arabic(romanToConvert: String): Int {
    var previous = 0
    var arabic = 0
    val romanArabicMap: Map<String, Int> = mapOf(
        "I" to 1,
        "V" to 5,
        "X" to 10,
        "L" to 50,
        "C" to 100,
        "D" to 500,
        "M" to 1000,
    )

    for (current in romanToConvert.reversed()) {
        val currentChar = "$current"
        var value: Int = romanArabicMap[currentChar]!!
        if (value < previous) {
            value *= -1
        }
        arabic += value
        previous = abs(value)
    }
    return arabic
}