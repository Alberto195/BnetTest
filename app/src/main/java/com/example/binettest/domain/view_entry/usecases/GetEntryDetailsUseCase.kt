package com.example.binettest.domain.view_entry.usecases

import com.example.binettest.domain.view_entry.models.EntryDetailsModel
import com.example.binettest.domain.view_entry.repositories.ViewEntryRepository

class GetEntryDetailsUseCase(
        private val repository: ViewEntryRepository
) {

    fun execute(): EntryDetailsModel {
        return repository.getEntryDetails()
    }
}