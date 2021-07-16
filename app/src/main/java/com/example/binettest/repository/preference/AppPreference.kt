package com.example.binettest.repository.preference

import android.content.Context
import android.content.SharedPreferences

class AppPreference(
    override val context: Context
) : IAppPreference {

    companion object {
        private const val NAME_PREF = "preference"
        private const val SESSION = "session"
    }

    override lateinit var preferences: SharedPreferences

    override fun initPreference() {
        preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
    }

    override fun getSessionValue(): String? {
        return preferences.getString(SESSION, "")
    }

    override fun setSessionValue(string: String) {
        preferences.edit()
                .putString(SESSION, string)
                .apply()
    }
}
