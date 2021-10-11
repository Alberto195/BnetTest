package com.example.binettest.data.storage

import com.example.binettest.domain.add_entry.models.UserSessionId

interface UserStorage {

    fun getSessionValue(): UserSessionId?
}