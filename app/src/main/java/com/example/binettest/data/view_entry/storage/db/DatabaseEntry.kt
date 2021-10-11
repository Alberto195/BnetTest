package com.example.binettest.data.view_entry.storage.db

import com.example.binettest.data.view_entry.storage.UserStorageEntry
import com.example.binettest.data.view_entry.storage.db.models.EntryDetailsDB
import com.example.binettest.data.view_entry.storage.models.WholeEntry

class DatabaseEntry(
    private val roomDao: RoomDao
) : UserStorageEntry {

    override fun getWholeEntry(): WholeEntry {
        return mapToStorage(roomDao.getEntry())
    }

    override fun deleteEntry(entry: WholeEntry) {
        roomDao.deleteEntry(entry = mapToDatabase(entry))
    }

    private fun mapToStorage(entry: EntryDetailsDB): WholeEntry {
        return WholeEntry(
            dateAdded = entry.dateAdded,
            dateModified = entry.dateModified,
            bodyText = entry.bodyText
        )
    }

    private fun mapToDatabase(entry: WholeEntry): EntryDetailsDB {
        return EntryDetailsDB(
            id = 0,
            dateAdded = entry.dateAdded,
            dateModified = entry.dateModified,
            bodyText = entry.bodyText
        )
    }
}