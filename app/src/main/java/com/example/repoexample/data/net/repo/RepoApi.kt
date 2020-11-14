package com.example.repoexample.data.net.repo

import com.example.repoexample.data.net.repo.model.RepoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RepoApi {
    @GET("/users/{username}}/repos")
    suspend fun getUserRepoList(@Path("username") username: String): List<RepoDto>

    @GET("/repositories")
    suspend fun getAllRepoList(): List<RepoDto>
}