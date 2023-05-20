package ru.statech.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import org.koin.ktor.ext.inject
import ru.statech.models.TodoUpdateDone
import ru.statech.services.TodoService
import java.util.UUID

fun Application.configureRouting() {
    val service by inject<TodoService>()

    routing {
        get("/todos") {
            val data = service.getAll()
            call.respond(data)
        }
        put("/todos/{id}/done") {
            var id = UUID.fromString(call.parameters.get("id")!!)
            val data = call.receive<TodoUpdateDone>()
            val item = service.updateDone(id, data)
            call.respond(if(item != null) HttpStatusCode.NoContent else HttpStatusCode.NotFound)
        }
    }
}
