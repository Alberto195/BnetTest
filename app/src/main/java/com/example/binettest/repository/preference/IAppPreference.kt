package com.example.binettest.repository.preference

import android.content.Context
import android.content.SharedPreferences

interface IAppPreference {
    val context: Context
    var preferences: SharedPreferences

    fun initPreference()

    fun getSessionValue(): String?

    fun setSessionValue(string: String)
}
