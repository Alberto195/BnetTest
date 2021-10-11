package com.example.binettest.data.entry_list.di

import com.example.binettest.data.entry_list.api_service.EntryApi
import com.example.binettest.data.entry_list.api_service.RetrofitInstance
import com.example.binettest.data.entry_list.mappers.EntryListMapper
import com.example.binettest.data.entry_list.repositories.EntryRepositoryImpl
import com.example.binettest.data.entry_list.storage.UserStorageDB
import com.example.binettest.data.entry_list.storage.UserStorageSharedPrefs
import com.example.binettest.data.entry_list.storage.db.DatabaseRepositoryImpl
import com.example.binettest.data.entry_list.storage.db.RoomDataBase
import com.example.binettest.data.entry_list.storage.sharedprefs.SharedPrefUserStorage
import com.example.binettest.domain.entry_list.repositories.EntryRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module


val entryListDataApiModule: Module = module {
    single<EntryApi?> { RetrofitInstance.retrofitInstance }
}

val entryListDataRepositoryModule: Module = module {
    single<EntryRepository> { EntryRepositoryImpl(get(), get(), get()) }

    single<RoomDataBase> { RoomDataBase.getInstance(androidContext()) }

    single { RoomDataBase.getInstance(androidContext()).getRoomDao() }

    single<UserStorageDB> { DatabaseRepositoryImpl(get()) }
}

val entryListDataMapperModule: Module = module {
    single { EntryListMapper() }
}

val entryListStorageModule: Module = module {
    single<UserStorageSharedPrefs> { SharedPrefUserStorage(androidContext()) }
}