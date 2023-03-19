package com.example.testttapplication.di

import com.example.testttapplication.presentation.viewmodel.JokesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        JokesViewModel(get())
    }
}