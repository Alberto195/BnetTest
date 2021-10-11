package com.example.binettest.domain.core.usecases

import com.example.binettest.domain.core.models.UserSessionId
import com.example.binettest.domain.core.repositories.UserSessionRepository

class GetSessionValueUseCase(
        private val repository: UserSessionRepository
) {

    fun execute(): UserSessionId? {
        return repository.getUserSessionId()
    }
}
