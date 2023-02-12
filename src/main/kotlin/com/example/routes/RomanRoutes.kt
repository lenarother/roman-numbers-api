package com.example.routes

import com.example.services.roman2arabic
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*


fun Route.rootRouting() {
    route("/") {
        get {
            val arabic: Int = roman2arabic("MCMLXXXIII")
            call.respondText("Welcome to roman to arabic converter $arabic!", status = HttpStatusCode.OK)
        }
    }
}


fun Route.romanRouting() {
    route("/roman/{num?}") {
        get("{num!!}") {
            val num = call.parameters["num"] ?: return@get call.respondText(
                "Missing roman number to convert",
                status = HttpStatusCode.BadRequest
            )
            val arabic: Int = roman2arabic(num)
            call.respondText("$arabic", status = HttpStatusCode.OK)

        }
    }
}

