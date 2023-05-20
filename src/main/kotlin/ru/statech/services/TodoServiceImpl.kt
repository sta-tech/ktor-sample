package ru.statech.services

import ru.statech.models.ListResponse
import ru.statech.models.Todo
import ru.statech.models.TodoUpdateDone
import java.time.Instant
import java.time.LocalDateTime
import java.util.UUID

class TodoServiceImpl : TodoService {
    private val items: MutableList<Todo> = mutableListOf()

    constructor() {
        items.add(Todo(
            UUID.randomUUID(),
            "Приготовить рыбу на ужин",
            "statech",
            Instant.now(),
            false,
        ));
        items.add(Todo(
            UUID.randomUUID(),
            "Убраться в ванной комнате",
            "statech",
            Instant.now(),
            false,
        ));
    }

    override fun getAll(): ListResponse<Todo> {
        return ListResponse(items.toList(), items.size)
    }

    override fun updateDone(id: UUID, data: TodoUpdateDone): Todo? {
        val item = items.find { it.id == id }
        if (item != null) {
            item.done = data.done
            return item
        }
        return null
    }
}