package com.example.binettest.domain.entry_list.repositories

import com.example.binettest.domain.entry_list.models.EntryListModel
import com.example.binettest.domain.core.models.UserSessionId

interface EntryRepository {
    fun getEntry(): List<EntryListModel?>

    fun setEntry(entry: EntryListModel?)
}
