package ru.statech.models

import kotlinx.serialization.Serializable
import ru.statech.serialization.InstantSerializer
import ru.statech.serialization.UUIDSerializer
import java.time.Instant
import java.util.UUID

@Serializable
data class TodoModel(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val title: String,
    val owner: String,
    @Serializable(with = InstantSerializer::class)
    val dueDate: Instant,
    var done: Boolean,
)