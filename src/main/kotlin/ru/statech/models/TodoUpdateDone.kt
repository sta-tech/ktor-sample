package ru.statech.models

import kotlinx.serialization.Serializable

@Serializable
data class TodoUpdateDone(
    val done: Boolean,
)