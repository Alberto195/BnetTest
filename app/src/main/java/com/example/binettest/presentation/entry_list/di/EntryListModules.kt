package com.example.binettest.presentation.entry_list.di

import com.example.binettest.domain.core.usecases.GetSessionValueUseCase
import com.example.binettest.domain.core.usecases.GetUserSessionIdUseCase
import com.example.binettest.domain.core.usecases.SetUserSessionUseCase
import com.example.binettest.domain.entry_list.usecases.GetEntryListUseCase
import com.example.binettest.presentation.entry_list.viewmodels.EntryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelEntryListModule: Module = module {
    viewModel { EntryListViewModel(get()) }
}

val useCasesEntryListModule: Module = module {
    factory { GetEntryListUseCase(get()) }
}