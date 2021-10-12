package com.example.binettest.data.core.mappers

import com.example.binettest.data.core.models.UserSessionDataModel
import com.example.binettest.domain.core.models.UserSessionId

class UserSessionMapper {

    fun userSessionDataModelToUserSessionId(sessionData: UserSessionDataModel?): UserSessionId {
        return UserSessionId(
                sessionId = sessionData?.data?.session
        )
    }

}