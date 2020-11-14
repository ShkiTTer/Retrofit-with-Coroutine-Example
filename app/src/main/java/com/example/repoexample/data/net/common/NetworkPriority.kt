package com.example.repoexample.data.net.common

import com.example.repoexample.data.net.priority.PriorityApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object NetworkPriority {
    private var _instance: PriorityApi? = null

    fun getInstance(): PriorityApi {
        val instance = _instance

        if (instance != null) return instance

        val newInstance = Retrofit
            .Builder()
            .baseUrl("http://practice.mobile.kreosoft.ru/api/")
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory("application/json".toMediaType())
            )
            .build().create(PriorityApi::class.java)

        _instance = newInstance
        return newInstance
    }
}