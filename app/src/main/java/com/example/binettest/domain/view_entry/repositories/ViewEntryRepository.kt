package com.example.binettest.domain.view_entry.repositories

import com.example.binettest.domain.view_entry.models.EntryDetailsModel

interface ViewEntryRepository {

    fun getEntryDetails(): EntryDetailsModel

    fun deleteEntry(entry: EntryDetailsModel)
}