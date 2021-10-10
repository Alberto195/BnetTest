package com.example.binettest.domain.entry_list.repositories

interface IAppPreference {
    fun getSessionValue(): String?

    fun setSessionValue(string: String)
}
