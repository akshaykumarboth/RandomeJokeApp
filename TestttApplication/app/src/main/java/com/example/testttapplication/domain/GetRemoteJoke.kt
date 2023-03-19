package com.example.testttapplication.domain

import com.example.testttapplication.repository.JokesRepository

//use case from fetching joke from remote serve
class GetRemoteJoke (
    private val repo: JokesRepository
) {
    suspend operator fun invoke() = repo.getJokeFromRemote()
}