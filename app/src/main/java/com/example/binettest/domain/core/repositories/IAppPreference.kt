package com.example.binettest.domain.core.repositories

import com.example.binettest.domain.core.models.UserSessionId

interface IAppPreference {
    fun getSessionValue(): UserSessionId?

    fun setSessionValue(userSessionId: UserSessionId?)
}
