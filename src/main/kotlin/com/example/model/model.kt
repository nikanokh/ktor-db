package com.example.model

import kotlinx.serialization.Serializable

enum class Priority{
    Low,Medium,High
}

@Serializable
data class Task(
    var name: String,
    val description: String,
    val priority: Priority
)