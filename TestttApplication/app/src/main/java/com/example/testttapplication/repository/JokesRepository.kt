package com.example.testttapplication.repository

import com.example.testttapplication.data.network.ApiResult
import com.example.testttapplication.data.model.JokeResponse

interface JokesRepository {
    suspend fun getJokeFromRemote() : ApiResult<JokeResponse>
    suspend fun getJokesFromLocal() : List<JokeResponse>
    suspend fun delete(joke: JokeResponse)
    suspend fun addJoke(joke: JokeResponse)
}