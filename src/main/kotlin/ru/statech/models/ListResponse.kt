package ru.statech.models

import kotlinx.serialization.Serializable

@Serializable
data class ListResponse<T>(
    val items: List<T>,
    val total: Int,
)