package com.example.binettest.data.add_entry.storage

import com.example.binettest.domain.add_entry.models.UserSessionId

interface UserStorage {

    fun getSessionValue(): UserSessionId?
}