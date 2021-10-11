package com.example.binettest.data.view_entry.repositories

import com.example.binettest.data.view_entry.api_service.AddApi
import com.example.binettest.data.view_entry.storage.UserStorage
import com.example.binettest.domain.view_entry.models.AddEntryModel
import com.example.binettest.domain.view_entry.repositories.ViewEntryRepository

class AddEntryRepositoryImpl(
        private val api: AddApi,
        private val userStorage: UserStorage
) : ViewEntryRepository {

    override fun addEntry(addEntry: AddEntryModel) {
        api.addEntry(
                a = "add_entry",
                session = userStorage.getSessionValue()?.sessionId,
                body = addEntry.bodyText
        )
    }
}