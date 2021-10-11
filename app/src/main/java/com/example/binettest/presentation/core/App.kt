package com.example.binettest.presentation.core

import android.app.Application
import com.example.binettest.data.di.addEntryApiModule
import com.example.binettest.data.di.addEntryRepositoryModule
import com.example.binettest.presentation.add_entry.di.addEntryUseCaseModule
import com.example.binettest.presentation.add_entry.di.addEntryViewModelModule
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
                            addEntryRepositoryModule,
                            addEntryApiModule,
                            addEntryViewModelModule,
                            addEntryUseCaseModule,
                    )
            )
        }

    }
}