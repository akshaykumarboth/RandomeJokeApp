package com.example.testttapplication.domain

data class UseCase(
    val getRemoteJoke: GetRemoteJoke,
    val getLocalJokes: GetLocalJokes,
    val addLocalJoke: AddLocalJoke,
    val deleteLocalJoke: DeleteLocalJoke
)