package com.example.routes

import com.example.services.roman2arabic
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*


fun Route.rootRouting() {
    route("/") {
        get {
            call.respondText("Welcome to roman to arabic converter!", status = HttpStatusCode.OK)
        }
    }
}


fun Route.romanRouting() {
    route("/roman") {
        get {
            call.respondText("Specify roman number to convert", status = HttpStatusCode.OK)
        }
        get("{num?}") {
            val num = call.parameters["num"] ?: return@get call.respondText(
                "Missing roman number to convert",
                status = HttpStatusCode.BadRequest
            )
            val arabic: Int = roman2arabic(num)
            call.respondText("$arabic", status = HttpStatusCode.OK)

        }
    }
}

