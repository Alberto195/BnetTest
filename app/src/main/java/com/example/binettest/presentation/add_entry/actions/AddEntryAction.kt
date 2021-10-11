package com.example.binettest.presentation.add_entry.actions

sealed class AddEntryAction {
    data class SaveClicked(
        val body: String
    ): AddEntryAction()

    data class BackClicked(
        val body: String
    ): AddEntryAction()
}