package com.example.binettest.data.core.repositories

import com.example.binettest.data.core.api_service.SessionApi
import com.example.binettest.data.core.mappers.UserSessionMapper
import com.example.binettest.domain.core.models.UserSessionId
import com.example.binettest.domain.core.repositories.UserSessionRepository

class UserSessionRepositoryImpl (
        private val api: SessionApi,
        private val userSessionMapper: UserSessionMapper
) : UserSessionRepository {

    override fun getUserSessionId(): UserSessionId {
        val call = api.getSession("new_session")

        return userSessionMapper.toUserSessionId(call?.execute()?.body())
    }
}
