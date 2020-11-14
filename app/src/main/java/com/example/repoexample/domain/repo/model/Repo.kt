package com.example.repoexample.domain.repo.model

data class Repo(
    val id: Long,
    val name: String,
    val fullName: String,
    val owner: Owner,
    val htmlUrl: String
)