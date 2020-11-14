package com.example.repoexample.data.net.repo.model

import com.example.repoexample.domain.repo.model.Repo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RepoDto(
    val id: Long,
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    val owner: OwnerDto,
    @SerialName("html_url")
    val htmlUrl: String
) {

    fun toDomain() = Repo(
        id = id,
        name = name,
        fullName = fullName,
        owner = owner.toDomain(),
        htmlUrl = htmlUrl
    )
}