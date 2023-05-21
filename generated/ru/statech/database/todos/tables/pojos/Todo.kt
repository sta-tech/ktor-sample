/*
 * This file is generated by jOOQ.
 */
package ru.statech.database.todos.tables.pojos


import java.io.Serializable
import java.time.OffsetDateTime
import java.util.UUID


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Todo(
    var id: UUID? = null,
    var title: String? = null,
    var owner: String? = null,
    var dueDate: OffsetDateTime? = null,
    var done: Boolean? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Todo = other as Todo
        if (this.id == null) {
            if (o.id != null)
                return false
        }
        else if (this.id != o.id)
            return false
        if (this.title == null) {
            if (o.title != null)
                return false
        }
        else if (this.title != o.title)
            return false
        if (this.owner == null) {
            if (o.owner != null)
                return false
        }
        else if (this.owner != o.owner)
            return false
        if (this.dueDate == null) {
            if (o.dueDate != null)
                return false
        }
        else if (this.dueDate != o.dueDate)
            return false
        if (this.done == null) {
            if (o.done != null)
                return false
        }
        else if (this.done != o.done)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.id == null) 0 else this.id.hashCode())
        result = prime * result + (if (this.title == null) 0 else this.title.hashCode())
        result = prime * result + (if (this.owner == null) 0 else this.owner.hashCode())
        result = prime * result + (if (this.dueDate == null) 0 else this.dueDate.hashCode())
        result = prime * result + (if (this.done == null) 0 else this.done.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Todo (")

        sb.append(id)
        sb.append(", ").append(title)
        sb.append(", ").append(owner)
        sb.append(", ").append(dueDate)
        sb.append(", ").append(done)

        sb.append(")")
        return sb.toString()
    }
}
