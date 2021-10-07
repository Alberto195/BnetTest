package com.example.binettest.repository.bnetRepo

import com.example.binettest.models.GetEntriesModel
import com.example.binettest.repository.api.BnetApi

interface IBnetRepository {
    val api: BnetApi

    fun getEntry(): GetEntriesModel?

    fun addEntry(body: String)

    fun getSessionValueApi(): String?
}