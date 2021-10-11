package com.example.binettest.data.entry_list.di

import com.example.binettest.data.entry_list.api_service.EntryApi
import com.example.binettest.data.entry_list.api_service.RetrofitInstance
import com.example.binettest.data.entry_list.mappers.EntryListMapper
import com.example.binettest.data.entry_list.repositories.EntryRepositoryImpl
import com.example.binettest.domain.entry_list.repositories.EntryRepository
import org.koin.core.module.Module
import org.koin.dsl.module


val apiEntryListModule: Module = module {
    single<EntryApi?> { RetrofitInstance.retrofitInstance }
}

val repositoryEntryListModule: Module = module {
    single<EntryRepository> { EntryRepositoryImpl(get(), get(), get()) }
}

val dataMapperEntryListModule: Module = module {
    single { EntryListMapper() }
}