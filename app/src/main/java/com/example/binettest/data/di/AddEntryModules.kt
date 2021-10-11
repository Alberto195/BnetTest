package com.example.binettest.data.di

import com.example.binettest.data.api_service.AddApi
import com.example.binettest.data.api_service.AddEntryRetrofit
import com.example.binettest.data.repositories.AddEntryRepositoryImpl
import com.example.binettest.data.repositories.AppPreferenceImpl
import com.example.binettest.domain.add_entry.repositories.AddEntryRepository
import com.example.binettest.domain.add_entry.repositories.AppPreference
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val addEntryRepositoryModule: Module = module {
    single<AddEntryRepository> { AddEntryRepositoryImpl(get(), get()) }

    single<AppPreference> { AppPreferenceImpl(androidContext()) }
}

val addEntryApiModule: Module = module {
    single<AddApi?> { AddEntryRetrofit.retrofitInstance }
}