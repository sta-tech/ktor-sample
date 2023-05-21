package ru.statech.services

import ru.statech.database.todos.tables.pojos.Todo
import ru.statech.models.ListResponse
import ru.statech.models.TodoModel
import ru.statech.models.TodoCreateRequest
import ru.statech.models.TodoUpdateDone
import java.time.ZoneOffset
import java.util.UUID

class TodoServiceImpl(
    private val repository: TodosRepository
) : TodoService {

    override fun getAll(): ListResponse<TodoModel> {
        val items = repository.getAll()
        return ListResponse(items.map { ConvertToModel(it)!! }, items.size)
    }

    override fun add(request: TodoCreateRequest): TodoModel {
        val item = Todo(
            UUID.randomUUID(),
            request.title,
            request.owner,
            request.dueDate.atOffset(ZoneOffset.UTC),
            request.done
        )
        repository.save(item)
        return ConvertToModel(item)!!;
    }

    override fun updateDone(id: UUID, data: TodoUpdateDone): TodoModel? {
        val item = repository.findById(id)
        if (item != null) {
            item.done = data.done
            repository.save(item)
            return ConvertToModel(item)
        }
        return null
    }

    override fun delete(id: UUID): TodoModel? {
        val item = repository.findById(id)
        if (item != null) {
            repository.delete(id)
            return ConvertToModel(item)
        }
        return null
    }

    private fun ConvertToModel(todo: Todo?): TodoModel? {
        if (todo == null) {
            return null
        }
        return TodoModel(
            todo.id!!, todo.title!!, todo.owner!!, todo.dueDate!!.toInstant(), todo.done!!)
    }
}