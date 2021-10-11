package com.example.binettest.domain.core.usecases

import com.example.binettest.domain.core.models.UserSessionId
import com.example.binettest.domain.core.repositories.IAppPreference
import com.example.binettest.domain.core.repositories.UserSessionRepository

class GetUserSessionIdUseCase(
        private val appPreference: IAppPreference
) {

    fun execute(): UserSessionId? {
        return appPreference.getSessionValue()
    }

}