package com.example.testttapplication.di

import com.example.testttapplication.repository.JokesRepository
import com.example.testttapplication.repository.JokesRepositoryImpl
import org.koin.dsl.module


val repoModule = module {
    single<JokesRepository> {
        JokesRepositoryImpl(get(),get())
    }
}