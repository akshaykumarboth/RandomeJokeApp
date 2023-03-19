package com.example.testttapplication.domain

import com.example.testttapplication.repository.JokesRepository

//use case from fetching joke from local database
class GetLocalJokes (
    private val repo: JokesRepository
) {
    suspend operator fun invoke() = repo.getJokesFromLocal()
}