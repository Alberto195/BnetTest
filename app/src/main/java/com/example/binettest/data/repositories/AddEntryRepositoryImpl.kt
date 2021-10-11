package com.example.binettest.data.repositories

import com.example.binettest.data.api_service.AddApi
import com.example.binettest.domain.add_entry.models.AddEntryModel
import com.example.binettest.domain.add_entry.repositories.AddEntryRepository
import com.example.binettest.domain.add_entry.repositories.AppPreference

class AddEntryRepositoryImpl(
        private val api: AddApi,
        private val appPreference: AppPreference
): AddEntryRepository
{

    override fun addEntry(addEntry: AddEntryModel) {
        api.addEntry(
                a = "add_entry",
                session = appPreference.getSessionValue()?.sessionId,
                body = addEntry.bodyText
        )
    }
}