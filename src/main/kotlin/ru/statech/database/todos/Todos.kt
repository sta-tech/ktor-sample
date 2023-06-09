/*
 * This file is generated by jOOQ.
 */
package ru.statech.database.todos


import kotlin.collections.List

import org.jooq.Catalog
import org.jooq.Table
import org.jooq.impl.SchemaImpl

import ru.statech.database.DefaultCatalog
import ru.statech.database.todos.tables.Todo


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Todos : SchemaImpl("TODOS", DefaultCatalog.DEFAULT_CATALOG) {
    public companion object {

        /**
         * The reference instance of <code>TODOS</code>
         */
        val TODOS: Todos = Todos()
    }

    /**
     * The table <code>TODOS.TODO</code>.
     */
    val TODO: Todo get() = Todo.TODO

    override fun getCatalog(): Catalog = DefaultCatalog.DEFAULT_CATALOG

    override fun getTables(): List<Table<*>> = listOf(
        Todo.TODO
    )
}
