package com.example.binettest.domain.core.usecases

import com.example.binettest.domain.core.models.UserSessionId
import com.example.binettest.domain.core.repositories.IAppPreference

class SetUserSessionUseCase(
        private val appPreference: IAppPreference
) {

    fun execute(userSessionId: UserSessionId?) {
        appPreference.setSessionValue(userSessionId)
    }

}