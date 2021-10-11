package com.example.binettest.data.storage.sharedprefs

import android.content.Context
import com.example.binettest.data.storage.UserStorage
import com.example.binettest.domain.add_entry.models.UserSessionId

class SharedPrefUserStorage(
        context: Context
): UserStorage {

    private val preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)

    override fun getSessionValue(): UserSessionId {
        return UserSessionId(
                sessionId = preferences.getString (SESSION, "")
        )
    }

    companion object {
        private const val NAME_PREF = "preference"
        private const val SESSION = "session"
    }

}