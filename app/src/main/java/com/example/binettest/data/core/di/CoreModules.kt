package com.example.binettest.data.core.di

import com.example.binettest.data.core.api_service.RetrofitUserSession
import com.example.binettest.data.core.api_service.SessionApi
import com.example.binettest.data.core.mappers.UserSessionMapper
import com.example.binettest.data.entry_list.api_service.EntryApi
import com.example.binettest.data.entry_list.api_service.RetrofitInstance
import com.example.binettest.data.entry_list.mappers.EntryListMapper
import com.example.binettest.domain.entry_list.repositories.EntryRepository
import com.example.binettest.data.core.repositories.AppPreference
import com.example.binettest.data.core.repositories.UserSessionRepositoryImpl
import com.example.binettest.data.entry_list.repositories.EntryRepositoryImpl
import com.example.binettest.domain.core.repositories.IAppPreference
import com.example.binettest.domain.core.repositories.UserSessionRepository
import com.example.binettest.presentation.entry_list.viewmodels.EntryListViewModel
import com.example.binettest.presentation.core.viewmodels.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val apiCoreModule: Module = module {
    single<SessionApi?> { RetrofitUserSession.retrofitInstance }
}

val repositoryCoreModule: Module = module {
    single<IAppPreference> { AppPreference(androidContext()) }

    single<UserSessionRepository> { UserSessionRepositoryImpl(get(), get()) }

}

val dataMapperCoreModule: Module = module {
    single { UserSessionMapper() }
}