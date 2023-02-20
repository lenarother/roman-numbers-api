package com.example.routes;

import com.example.module

import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RomanRoutingTest {

    @Test
    fun testGetRoman() = testApplication {
        application {
            module()
        }
        client.get("/roman").apply {
            val response = client.get("/roman")
            assertEquals(HttpStatusCode.OK, response.status)
            assertEquals("Specify roman number to convert", response.bodyAsText())
        }
    }

    @Test
    fun testGetRomanNum() = testApplication {
        application {
            module()
        }
        val parameters = listOf(
            "I" to "1",
            "II" to "2",
            "III" to "3",
            "V" to "5",
            "X" to "10",
            "XV" to "15",
            "VI" to "6",
            "IV" to "4",
            "MCMLXXXV" to "1985",
        )
        parameters.forEach { (romanNum, expected) ->
            client.get("/roman/$romanNum").apply {
                val response = client.get("/roman/$romanNum")
                assertEquals(HttpStatusCode.OK, response.status)
                assertEquals(expected, response.bodyAsText())

            }

        }
    }
}