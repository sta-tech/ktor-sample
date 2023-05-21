package ru.statech.models

import kotlinx.serialization.Serializable
import ru.statech.serialization.InstantSerializer
import java.time.Instant

@Serializable
data class TodoCreateRequest(
    val title: String,
    val owner: String,
    @Serializable(with = InstantSerializer::class)
    val dueDate: Instant,
    val done: Boolean,
)