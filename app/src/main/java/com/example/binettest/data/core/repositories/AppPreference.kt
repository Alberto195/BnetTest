package com.example.binettest.data.core.repositories

import android.content.Context
import com.example.binettest.domain.core.models.UserSessionId
import com.example.binettest.domain.core.repositories.IAppPreference

class AppPreference(
    context: Context
) : IAppPreference {

    private val preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)

    override fun getSessionValue(): UserSessionId {
        return UserSessionId(
                sessionId = preferences.getString (SESSION, "")
        )
    }

    override fun setSessionValue(userSessionId: UserSessionId?) {
        preferences.edit()
                .putString(SESSION, userSessionId?.sessionId)
                .apply()
    }

    companion object {
        private const val NAME_PREF = "preference"
        private const val SESSION = "session"
    }

}
