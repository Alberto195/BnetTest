package com.example.binettest.data.core.di

import com.example.binettest.data.core.api_service.RetrofitUserSession
import com.example.binettest.data.core.api_service.SessionApi
import com.example.binettest.data.core.mappers.UserSessionMapper
import com.example.binettest.data.entry_list.storage.sharedprefs.SharedPrefUserStorage
import com.example.binettest.data.core.repositories.UserSessionRepositoryImpl
import com.example.binettest.data.core.storage.UserStorageCore
import com.example.binettest.data.core.storage.sharedprefs.SharedPrefUserStorageCore
import com.example.binettest.data.entry_list.storage.UserStorage
import com.example.binettest.domain.core.repositories.UserSessionRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module


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