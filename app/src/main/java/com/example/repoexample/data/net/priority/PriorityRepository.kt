package com.example.repoexample.data.net.priority

import com.example.repoexample.data.net.priority.model.Priority

class PriorityRepository(
    private val api: PriorityApi
) {

    suspend fun getAllPriorities(): List<Priority> {
        return api.getAllPriorities("Bearer tHNocfZvLBVmkhtqBwZUx6HTqqedMeUHLmltpG0LT3hx0Z0SC8RfiNsNiwkV")
    }
}