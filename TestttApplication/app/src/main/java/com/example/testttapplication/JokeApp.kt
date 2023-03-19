package com.example.testttapplication

import android.app.Application
import com.example.testttapplication.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JokeApp: Application() {

    val modules = listOf(repoModule, retrofitModule, viewModelModule, jokesDBModule, useCaseModule)
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JokeApp)
            modules(modules)
        }
    }
}
