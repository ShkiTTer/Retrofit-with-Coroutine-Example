package com.example.repoexample.data.net.repo.model

import com.example.repoexample.domain.repo.model.Owner
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerDto(
    val login: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("html_url")
    val htmlUrl: String
) {

    fun toDomain() = Owner(
        login = login,
        avatarUrl = avatarUrl,
        htmlUrl = htmlUrl
    )
}