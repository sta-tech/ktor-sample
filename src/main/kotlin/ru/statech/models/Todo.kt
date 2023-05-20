package ru.statech.models

import kotlinx.serialization.Serializable
import ru.statech.serialization.InstantSerializer
import ru.statech.serialization.UUIDSerializer
import java.time.Instant
import java.util.UUID

@Serializable
data class Todo(
    @Serializable(with = UUIDSerializer::class)
    var id: UUID,
    var title: String,
    var owner: String,
    @Serializable(with = InstantSerializer::class)
    var dueDate: Instant,
    var done: Boolean,
)