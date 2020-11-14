package com.example.repoexample.data.net.repo

import com.example.repoexample.domain.repo.RepoDataSource
import com.example.repoexample.domain.repo.model.Repo

class RepoDataSourceImpl(
    private val api: RepoApi
) : RepoDataSource {

    override suspend fun getAllRepoList(): List<Repo> {
        return api.getAllRepoList().map { it.toDomain() }
    }

    override suspend fun getUserRepoList(username: String): List<Repo> {
        TODO("Not yet implemented")
    }
}