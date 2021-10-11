package com.example.binettest.domain.view_entry.usecases

import com.example.binettest.domain.view_entry.models.AddEntryModel
import com.example.binettest.domain.view_entry.repositories.AddEntryRepository

class AddEntryUseCase(
        private val repository: AddEntryRepository
) {

    fun execute(addEntryModel: AddEntryModel) {
        return repository.addEntry(addEntryModel)
    }
}