package com.example.testttapplication.domain

import com.example.testttapplication.data.model.JokeResponse
import com.example.testttapplication.repository.JokesRepository

//use case to add joke from local database
class AddLocalJoke(
    private val repo: JokesRepository
) {
    suspend operator fun invoke(joke: JokeResponse) = repo.addJoke(joke)
}