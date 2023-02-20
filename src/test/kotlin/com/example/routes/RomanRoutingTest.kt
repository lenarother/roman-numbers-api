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
        client.get("/roman/I").apply {
            val response = client.get("/roman/I")
            assertEquals(HttpStatusCode.OK, response.status)
            assertEquals("1", response.bodyAsText())

        }
    }
}