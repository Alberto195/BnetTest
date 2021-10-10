package com.example.binettest.domain.entry_list.usecases

import com.example.binettest.domain.entry_list.models.EntryListModel
import com.example.binettest.domain.entry_list.repositories.IBnetRepository
import io.reactivex.rxjava3.core.Single

class GetEntryListUseCase(
        private val repository: IBnetRepository
) {

    fun execute(): Single<List<EntryListModel?>> {
        return repository.getEntry()
    }

}