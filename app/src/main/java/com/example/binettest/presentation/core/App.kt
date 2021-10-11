package com.example.binettest.presentation.core

import android.app.Application
import com.example.binettest.data.core.di.apiCoreModule
import com.example.binettest.data.core.di.dataMapperCoreModule
import com.example.binettest.data.core.di.repositoryCoreModule
import com.example.binettest.data.entry_list.di.apiEntryListModule
import com.example.binettest.data.entry_list.di.dataMapperEntryListModule
import com.example.binettest.data.entry_list.di.repositoryEntryListModule
import com.example.binettest.presentation.core.di.useCasesCoreModule
import com.example.binettest.presentation.core.di.viewModelCoreModule
import com.example.binettest.presentation.entry_list.di.useCasesEntryListModule
import com.example.binettest.presentation.entry_list.di.viewModelEntryListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            modules(
                listOf(
                        apiCoreModule,
                        repositoryCoreModule,
                        dataMapperCoreModule,
                        apiEntryListModule,
                        repositoryEntryListModule,
                        dataMapperEntryListModule,
                        viewModelCoreModule,
                        viewModelEntryListModule,
                        useCasesCoreModule,
                        useCasesEntryListModule
                )
            )
        }

    }
}