package com.example.binettest.data.entry_list.storage

import com.example.binettest.data.entry_list.storage.models.UserSession

interface UserStorage {
    fun getSessionValue(): UserSession?
}
