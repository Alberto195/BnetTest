package com.example.binettest.data.entry_list.repositories

import android.content.Context
import com.example.binettest.domain.entry_list.repositories.IAppPreference

class AppPreference(
    context: Context
) : IAppPreference {

    private val preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)

    override fun getSessionValue(): String? {
        return preferences.getString(SESSION, "")
    }

    override fun setSessionValue(string: String) {
        preferences.edit()
                .putString(SESSION, string)
                .apply()
    }

    companion object {
        private const val NAME_PREF = "preference"
        private const val SESSION = "session"
    }

}
