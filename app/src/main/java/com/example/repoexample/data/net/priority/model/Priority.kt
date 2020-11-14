package com.example.repoexample.data.net.priority.model

import kotlinx.serialization.Serializable

@Serializable
data class Priority(
    val id: Int,
    val name: String,
    val color: String
)