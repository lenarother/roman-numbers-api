package com.example.plugins

import com.example.routes.romanRouting
import com.example.routes.rootRouting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        rootRouting()
        romanRouting()
    }
}
