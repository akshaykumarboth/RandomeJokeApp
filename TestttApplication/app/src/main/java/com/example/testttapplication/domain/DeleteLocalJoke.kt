package com.example.testttapplication.domain

import com.example.testttapplication.data.model.JokeResponse
import com.example.testttapplication.repository.JokesRepository

//use case to delete joke from local database
class DeleteLocalJoke(
    private val repo: JokesRepository
) {
    suspend operator fun invoke(joke: JokeResponse) = repo.delete(joke)
}