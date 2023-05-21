package ru.statech.services

import org.jooq.Configuration
import ru.statech.database.todos.tables.pojos.Todo
import java.util.*
import ru.statech.database.todos.tables.references.TODO

class JooqTodosRepositoryImpl(
    private val jooqConfiguration: Configuration,
): TodosRepository {
    override fun getAll(): List<Todo> {
        val data = jooqConfiguration.dsl()
            .select()
            .from(TODO)
            .fetchInto(Todo::class.java)
        return data.toList()
    }

    override fun findById(id: UUID): Todo? {
        val item = jooqConfiguration.dsl()
            .select()
            .from(TODO)
            .where(TODO.ID.eq(id))
            .fetchAny()
            ?.into(Todo::class.java)
        return item
    }

    override fun save(todo: Todo) {
        var todoRecord = jooqConfiguration.dsl().newRecord(TODO, todo)
        todoRecord.merge()
    }

    override fun delete(id: UUID) {
        jooqConfiguration.dsl()
            .deleteFrom(TODO)
            .where(TODO.ID.eq(id))
            .execute()
    }
}