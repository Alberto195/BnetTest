package com.example.binettest.mvi.actions

sealed class AddEntryAction {
    data class SaveClicked(
        val body: String
    ): AddEntryAction()

    data class BackClicked(
        val body: String
    ): AddEntryAction()
}