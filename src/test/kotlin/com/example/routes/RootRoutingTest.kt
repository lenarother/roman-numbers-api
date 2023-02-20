package com.example.routes;

import com.example.module

import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class RootRoutingTest {

    @Test
    fun testGet() = testApplication {
        application {
            module()
        }
        client.get("/").apply {
            val response = client.get("/")
            assertEquals(HttpStatusCode.OK, response.status)
            assertEquals("Welcome to roman to arabic converter!", response.bodyAsText())
        }
    }
}