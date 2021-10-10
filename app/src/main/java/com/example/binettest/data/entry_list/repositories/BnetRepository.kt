package com.example.binettest.data.entry_list.repositories

import com.example.binettest.domain.entry_list.repositories.IBnetRepository
import com.example.binettest.data.entry_list.api_service.BnetApi
import com.example.binettest.data.entry_list.mappers.EntryListMapper
import com.example.binettest.domain.entry_list.models.EntryListModel
import com.example.binettest.domain.entry_list.repositories.IAppPreference
import io.reactivex.rxjava3.core.Single

class BnetRepository (
        private val api: BnetApi,
        private val appPreference: IAppPreference,
        private val mapper: EntryListMapper
) : IBnetRepository {

    override fun getEntry(): Single<List<EntryListModel?>> {
        return api.getEntries("get_entries", appPreference.getSessionValue())
                .map {
                    mapper.toEntryListModel(it)
                }
    }
}
