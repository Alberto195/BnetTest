package com.example.binettest.data.entry_list.repositories

import com.example.binettest.domain.entry_list.repositories.EntryRepository
import com.example.binettest.data.entry_list.api_service.EntryApi
import com.example.binettest.data.entry_list.mappers.EntryListMapper
import com.example.binettest.domain.entry_list.models.EntryListModel
import com.example.binettest.data.entry_list.storage.UserStorage

class EntryRepositoryImpl (
        private val api: EntryApi,
        private val userStorage: UserStorage,
        private val entryListMapper: EntryListMapper,
) : EntryRepository {

    override fun getEntry(): List<EntryListModel?> {
        val call = api.getEntries("get_entries", userStorage.getSessionValue()?.sessionId)

        return entryListMapper.toEntryListModel(call?.execute()?.body())
    }
}
