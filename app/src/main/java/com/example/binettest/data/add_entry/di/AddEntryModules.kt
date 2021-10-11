package com.example.binettest.data.add_entry.di

import com.example.binettest.data.add_entry.api_service.AddApi
import com.example.binettest.data.add_entry.api_service.AddEntryRetrofit
import com.example.binettest.data.add_entry.repositories.AddEntryRepositoryImpl
import com.example.binettest.data.add_entry.repositories.AppPreferenceImpl
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