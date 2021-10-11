package com.example.binettest.data.view_entry.di

import com.example.binettest.data.view_entry.repositories.ViewEntryRepositoryImpl
import com.example.binettest.data.view_entry.storage.UserStorageEntry
import com.example.binettest.data.view_entry.storage.db.DatabaseEntry
import com.example.binettest.data.view_entry.storage.db.RoomDataBase
import com.example.binettest.domain.view_entry.repositories.ViewEntryRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val wholeEntryRepositoryModule: Module = module {
    single<ViewEntryRepository> { ViewEntryRepositoryImpl(get()) }

    single<UserStorageEntry> { DatabaseEntry(get()) }
}

val wholeEntryRoomDaoModule: Module = module {
    single<RoomDataBase> { RoomDataBase.getInstance(androidContext()) }

    single { RoomDataBase.getInstance(androidContext()).getRoomDao() }

}
