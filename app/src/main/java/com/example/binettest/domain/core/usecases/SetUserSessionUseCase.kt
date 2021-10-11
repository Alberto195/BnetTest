package com.example.binettest.domain.core.usecases

import com.example.binettest.data.core.storage.UserStorageCore
import com.example.binettest.domain.core.models.UserSessionId
import com.example.binettest.data.entry_list.storage.UserStorage
import com.example.binettest.domain.core.repositories.UserSessionRepository

class SetUserSessionUseCase(
        private val repository: UserSessionRepository
) {

    fun execute(userSessionId: UserSessionId?) {
        repository.setStorageSessionValue(userSessionId)
    }

}