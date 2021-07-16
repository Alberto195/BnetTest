package com.example.binettest.di

import com.example.binettest.repository.api.BnetApi
import com.example.binettest.repository.bnetRepo.BnetRepository
import com.example.binettest.repository.bnetRepo.IBnetRepository
import com.example.binettest.repository.preference.AppPreference
import com.example.binettest.repository.preference.IAppPreference
import com.example.binettest.viewmodels.AddEntryViewModel
import com.example.binettest.viewmodels.EntryListViewModel
import com.example.binettest.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val viewModelModule: Module = module {

    viewModel { AddEntryViewModel(get()) }

    viewModel { EntryListViewModel(get()) }

    viewModel { MainViewModel(get(), get()) }
}

val apiModule: Module = module {
    single { BnetApi.invoke()!! }
}

val repositoryModule: Module = module {
    single<IAppPreference> { AppPreference(androidContext()) }

    single<IBnetRepository> { BnetRepository(get(), get()) }

}