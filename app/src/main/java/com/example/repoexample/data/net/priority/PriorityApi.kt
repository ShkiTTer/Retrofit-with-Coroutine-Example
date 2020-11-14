package com.example.repoexample.data.net.priority

import com.example.repoexample.data.net.priority.model.Priority
import retrofit2.http.GET
import retrofit2.http.Header

interface PriorityApi {
    @GET("priorities")
    suspend fun getAllPriorities(@Header("Authorization") token: String): List<Priority>
}