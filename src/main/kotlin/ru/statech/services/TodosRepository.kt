package ru.statech.services

import ru.statech.database.todos.tables.pojos.Todo
import java.util.UUID

interface TodosRepository {
    fun getAll(): List<Todo>
    fun findById(id: UUID): Todo?
    fun save(todo: Todo)
    fun delete(id: UUID)
}