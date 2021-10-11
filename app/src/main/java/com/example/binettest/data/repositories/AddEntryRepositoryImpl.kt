package com.example.binettest.data.repositories

import com.example.binettest.data.api_service.AddApi
import com.example.binettest.data.storage.UserStorage
import com.example.binettest.domain.add_entry.models.AddEntryModel
import com.example.binettest.domain.add_entry.repositories.AddEntryRepository

class AddEntryRepositoryImpl(
        private val api: AddApi,
        private val userStorage: UserStorage
) : AddEntryRepository {

    override fun addEntry(addEntry: AddEntryModel) {
        api.addEntry(
                a = "add_entry",
                session = userStorage.getSessionValue()?.sessionId,
                body = addEntry.bodyText
        )
    }
}