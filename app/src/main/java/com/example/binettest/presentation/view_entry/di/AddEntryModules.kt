package com.example.binettest.presentation.add_entry.di

import com.example.binettest.domain.add_entry.usecases.AddEntryUseCase
import com.example.binettest.presentation.add_entry.viewmodels.AddEntryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val addEntryViewModelModule: Module = module {
    viewModel { AddEntryViewModel(get()) }
}

val addEntryUseCaseModule: Module = module {
    factory { AddEntryUseCase(get()) }
}