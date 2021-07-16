package com.example.binettest

import android.app.Application
import com.example.binettest.di.apiModule
import com.example.binettest.di.repositoryModule
import com.example.binettest.di.viewModelModule
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
                    apiModule
                )
            )
        }

    }
}