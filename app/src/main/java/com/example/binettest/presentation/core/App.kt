package com.example.binettest.presentation.core

import android.app.Application
import com.example.binettest.data.entry_list.di.apiModule
import com.example.binettest.data.entry_list.di.dataMapperModule
import com.example.binettest.data.entry_list.di.repositoryModule
import com.example.binettest.data.entry_list.di.viewModelModule
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
                    viewModelModule,
                    repositoryModule,
                    apiModule,
                    dataMapperModule
                )
            )
        }

    }
}