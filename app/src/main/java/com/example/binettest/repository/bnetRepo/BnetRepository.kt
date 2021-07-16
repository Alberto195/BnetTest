package com.example.binettest.repository.bnetRepo

import com.example.binettest.models.GetEntriesModel
import com.example.binettest.repository.api.BnetApi
import com.example.binettest.repository.preference.AppPreference
import com.example.binettest.repository.preference.IAppPreference

class BnetRepository (
    override val api: BnetApi,
    private val appPreference: IAppPreference
) : IBnetRepository {

    override fun getSessionValueApi(): String {
        val call = api.getSession("new_session")
        return call.execute().body()!!.data.session
    }

    override fun getEntry(): GetEntriesModel {
        val call = api.getEntries("get_entries", appPreference.getSessionValue()!!)
        return call.execute().body()!!
    }

    override fun addEntry(body: String) {
        val call = api.addEntry("add_entry", appPreference.getSessionValue()!!, body)
        call.execute()
    }
}
