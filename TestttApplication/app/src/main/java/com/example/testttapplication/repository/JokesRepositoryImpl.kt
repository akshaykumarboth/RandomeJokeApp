package com.example.testttapplication.repository

import com.example.testttapplication.data.local.JokesDao
import com.example.testttapplication.data.network.ApiResult
import com.example.testttapplication.data.network.safeApiCall
import com.example.testttapplication.data.model.JokeResponse
import com.example.testttapplication.data.network.JokesApiService

class JokesRepositoryImpl(
    private val service : JokesApiService,
    private val dao: JokesDao
): JokesRepository {
    override suspend fun getJokeFromRemote() : ApiResult<JokeResponse> =
        safeApiCall{
            service.getJoke()
        }

    override suspend fun getJokesFromLocal(): List<JokeResponse> {
       return dao.getAllJokes()
    }

    override suspend fun delete(joke: JokeResponse) {
       dao.delete(joke)
    }

    override suspend fun addJoke(joke: JokeResponse) {
        dao.insert(joke)
    }
}