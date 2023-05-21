package ru.statech.services

import ru.statech.models.ListResponse
import ru.statech.models.TodoModel
import ru.statech.models.TodoCreateRequest
import ru.statech.models.TodoUpdateDone
import java.util.UUID

interface TodoService {
    fun getAll(): ListResponse<TodoModel>;
    fun add(request: TodoCreateRequest): TodoModel;
    fun updateDone(id: UUID, data: TodoUpdateDone): TodoModel?;
    fun delete(id: UUID): TodoModel?;
}