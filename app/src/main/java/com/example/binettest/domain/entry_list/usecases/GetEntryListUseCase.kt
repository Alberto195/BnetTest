package com.example.binettest.domain.entry_list.usecases

import com.example.binettest.domain.entry_list.models.EntryListModel
import com.example.binettest.domain.entry_list.repositories.EntryRepository

class GetEntryListUseCase(
        private val repository: EntryRepository
) {

    fun execute(): List<EntryListModel?> {
        return repository.getEntry()
    }

}