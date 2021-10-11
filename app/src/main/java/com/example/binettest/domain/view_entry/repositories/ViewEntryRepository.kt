package com.example.binettest.domain.view_entry.repositories

import com.example.binettest.domain.view_entry.models.AddEntryModel

interface AddEntryRepository {

    fun show(addEntry: AddEntryModel)
}