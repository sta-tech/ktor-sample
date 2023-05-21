package ru.statech.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import org.koin.ktor.ext.inject
import ru.statech.models.TodoCreateRequest
import ru.statech.models.TodoUpdateDone
import ru.statech.services.TodoService
import java.util.UUID

fun Application.configureRouting() {
    val service by inject<TodoService>()

    routing {
        get("/todos") {
            val data = service.getAll()
            call.respond(HttpStatusCode.OK, data)
        }
        post("/todos") {
            val request = call.receive<TodoCreateRequest>()
            val item = service.add(request)
            call.respond(HttpStatusCode.OK, item)
        }
        put("/todos/{id}/done") {
            var id = UUID.fromString(call.parameters.get("id")!!)
            val data = call.receive<TodoUpdateDone>()
            val item = service.updateDone(id, data)
            call.respond(if(item != null) HttpStatusCode.OK else HttpStatusCode.NotFound)
        }
        delete("/todos/{id}") {
            var id = UUID.fromString(call.parameters.get("id")!!)
            val item = service.delete(id)
            call.respond(if(item != null) HttpStatusCode.OK else HttpStatusCode.NotFound)
        }
    }
}
