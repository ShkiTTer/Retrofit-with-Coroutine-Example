package com.example.repoexample.domain.repo

import com.example.repoexample.domain.repo.model.Repo

interface RepoDataSource {
    suspend fun getAllRepoList(): List<Repo>
    suspend fun getUserRepoList(username: String): List<Repo>
}