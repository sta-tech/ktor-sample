package ru.statech.services

import ru.statech.models.ListResponse
import ru.statech.models.Todo
import ru.statech.models.TodoCreateRequest
import ru.statech.models.TodoUpdateDone
import java.util.UUID

interface TodoService {
    fun getAll(): ListResponse<Todo>;
    fun add(request: TodoCreateRequest): Todo;
    fun updateDone(id: UUID, data: TodoUpdateDone): Todo?;
    fun delete(id: UUID): Todo?;
}