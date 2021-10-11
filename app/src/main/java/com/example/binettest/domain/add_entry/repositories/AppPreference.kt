package com.example.binettest.domain.add_entry.repositories

import com.example.binettest.domain.add_entry.models.UserSessionId

interface AppPreference {
    fun getSessionValue(): UserSessionId?
}