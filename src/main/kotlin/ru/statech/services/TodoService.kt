package ru.statech.services

import ru.statech.models.ListResponse
import ru.statech.models.Todo
import ru.statech.models.TodoUpdateDone
import java.util.UUID

interface TodoService {
    fun getAll(): ListResponse<Todo>;
    fun updateDone(id: UUID, data: TodoUpdateDone): Todo?;
}