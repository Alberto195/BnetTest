package com.example.binettest.data.entry_list.mappers

import com.example.binettest.data.entry_list.models.EntryDataListModel
import com.example.binettest.domain.entry_list.models.EntryListModel

class EntryListMapper() {

    fun toEntryListModel(dataList: EntryDataListModel?): List<EntryListModel> {
        val result = mutableListOf<EntryListModel>()
        dataList?.data?.get(0)?.forEach {
            result.add(
                    EntryListModel (
                            dateAdded = it.da,
                            dateModified = it.dm,
                            entryText = it.body
                            )
            )
        }
        return result.toList()
    }

}