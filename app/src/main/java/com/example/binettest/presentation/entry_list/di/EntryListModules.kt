package com.example.binettest.presentation.entry_list.di

import com.example.binettest.domain.entry_list.usecases.GetEntryListUseCase
import com.example.binettest.presentation.entry_list.viewmodels.EntryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val entryListViewModelModule: Module = module {
    viewModel { EntryListViewModel(get()) }
}

val entryListUseCasesModule: Module = module {
    factory { GetEntryListUseCase(get()) }
}