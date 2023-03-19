package com.example.testttapplication.data.network

import com.example.testttapplication.data.model.JokeResponse
import retrofit2.http.GET

interface JokesApiService {

    @GET("api?format=json")
    suspend fun getJoke(): JokeResponse
}