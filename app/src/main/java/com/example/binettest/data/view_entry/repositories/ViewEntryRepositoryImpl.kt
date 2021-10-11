package com.example.binettest.data.view_entry.repositories

import com.example.binettest.data.view_entry.storage.UserStorageEntry
import com.example.binettest.data.view_entry.storage.models.WholeEntry
import com.example.binettest.domain.view_entry.models.EntryDetailsModel
import com.example.binettest.domain.view_entry.repositories.ViewEntryRepository

class ViewEntryRepositoryImpl(
        private val userStorage: UserStorageEntry
) : ViewEntryRepository {

    override fun getEntryDetails(): EntryDetailsModel {
        return mapToDomain(userStorage.getWholeEntry())
    }

    override fun deleteEntry(entry: EntryDetailsModel) {
        userStorage.deleteEntry(entry = mapToStorage(entry))
    }

    private fun mapToDomain(entry: WholeEntry): EntryDetailsModel {
        return EntryDetailsModel(
            dateAdded = entry.dateAdded,
            dateModified = entry.dateModified,
            bodyText = entry.bodyText
        )
    }

    private fun mapToStorage(entry: EntryDetailsModel): WholeEntry {
        return WholeEntry(
            dateAdded = entry.dateAdded,
            dateModified = entry.dateModified,
            bodyText = entry.bodyText
        )
    }
}
