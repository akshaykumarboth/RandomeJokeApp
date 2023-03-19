package com.example.testttapplication.di

import com.example.testttapplication.domain.*
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetRemoteJoke(get())
    }
    factory {
        GetLocalJokes(get())
    }
    factory {
        AddLocalJoke(get())
    }
    factory {
        DeleteLocalJoke(get())
    }
    single { UseCase(
        getRemoteJoke = get(),
        getLocalJokes = get(),
        addLocalJoke = get(),
        deleteLocalJoke = get())
    }

}