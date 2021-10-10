package com.example.binettest.data.entry_list.di

import com.example.binettest.data.entry_list.api_service.BnetApi
import com.example.binettest.data.entry_list.api_service.RetrofitInstance
import com.example.binettest.data.entry_list.mappers.EntryListMapper
import com.example.binettest.data.entry_list.repositories.BnetRepository
import com.example.binettest.domain.entry_list.repositories.IBnetRepository
import com.example.binettest.data.entry_list.repositories.AppPreference
import com.example.binettest.domain.entry_list.repositories.IAppPreference
import com.example.binettest.presentation.entry_list.viewmodels.EntryListViewModel
import com.example.binettest.presentation.core.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val viewModelModule: Module = module {

    viewModel { EntryListViewModel(get()) }

    viewModel { MainViewModel(get(), get()) }
}

val apiModule: Module = module {
    single<BnetApi?> { RetrofitInstance.retrofitInstance }

}

val repositoryModule: Module = module {
    single<IAppPreference> { AppPreference(androidContext()) }

    single<IBnetRepository> { BnetRepository(get(), get(), get()) }

}

val dataMapperModule: Module = module {
    single { EntryListMapper() }
}