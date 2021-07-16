package com.example.binettest.mvi.states

sealed class AddEntryViewState {
    object AddSuccessful: AddEntryViewState()
    object AddFailed: AddEntryViewState()
    object CleanSuccessful: AddEntryViewState()
    object CleanFailed: AddEntryViewState()
}