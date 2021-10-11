package com.example.binettest.presentation.view_entry.di

import com.example.binettest.domain.view_entry.usecases.GetEntryDetailsUseCase
import com.example.binettest.presentation.view_entry.viewmodels.ViewEntryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val addEntryViewModelModule: Module = module {
    viewModel { ViewEntryViewModel(get()) }
}

val addEntryUseCaseModule: Module = module {
    factory { GetEntryDetailsUseCase(get()) }
}