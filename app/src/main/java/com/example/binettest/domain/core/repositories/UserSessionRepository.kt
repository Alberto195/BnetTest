package com.example.binettest.domain.core.repositories

import com.example.binettest.domain.core.models.UserSessionId

interface UserSessionRepository {

    fun getNewUserSessionId(): UserSessionId?

    fun getStorageSessionId(): UserSessionId?

    fun setStorageSessionValue(userSessionId: UserSessionId?)

}