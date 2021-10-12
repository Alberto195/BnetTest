package com.example.binettest.data.di

import com.example.binettest.data.core.api_service.RetrofitUserSession
import com.example.binettest.data.core.api_service.SessionApi
import com.example.binettest.data.core.mappers.UserSessionMapper
import com.example.binettest.data.core.repositories.UserSessionRepositoryImpl
import com.example.binettest.data.core.storage.UserStorageCore
import com.example.binettest.data.core.storage.sharedprefs.SharedPrefUserStorageCore
import com.example.binettest.data.entry_list.api_service.EntryApi
import com.example.binettest.data.entry_list.api_service.RetrofitInstance
import com.example.binettest.data.entry_list.mappers.EntryListMapper
import com.example.binettest.data.entry_list.repositories.EntryRepositoryImpl
import com.example.binettest.data.entry_list.storage.UserStorageDB
import com.example.binettest.data.entry_list.storage.UserStorageSharedPrefs
import com.example.binettest.data.entry_list.storage.db.DatabaseRepositoryImpl
import com.example.binettest.data.entry_list.storage.db.RoomDataBase
import com.example.binettest.data.entry_list.storage.sharedprefs.SharedPrefUserStorage
import com.example.binettest.domain.core.repositories.UserSessionRepository
import com.example.binettest.domain.entry_list.repositories.EntryRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit


val entryListDataApiModule: Module = module {
    single<EntryApi?> { RetrofitInstance.retrofitInstance }

    fun provideEntryApi(retrofit: Retrofit): EntryApi = retrofit.create(EntryApi::class.java)

    fun provideSessionApi(retrofit: Retrofit): SessionApi = retrofit.create(SessionApi::class.java)

}

val entryListDataRepositoryModule: Module = module {
    single<EntryRepository> { EntryRepositoryImpl(get(), get(), get(), get()) }

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

val coreApiModule: Module = module {
    single<SessionApi?> { RetrofitUserSession.retrofitInstance }
}

val coreRepositoryModule: Module = module {
    single<UserSessionRepository> { UserSessionRepositoryImpl(get(), get(), get()) }

}

val coreDataMapperModule: Module = module {
    single { UserSessionMapper() }
}

val coreStorageModule: Module = module {
    single<UserStorageCore> { SharedPrefUserStorageCore(androidContext()) }
}