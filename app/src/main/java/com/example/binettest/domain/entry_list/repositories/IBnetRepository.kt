package com.example.binettest.domain.entry_list.repositories

import com.example.binettest.domain.entry_list.models.EntryListModel
import io.reactivex.rxjava3.core.Single

interface IBnetRepository {
    fun getEntry(): Single<List<EntryListModel?>>
}
