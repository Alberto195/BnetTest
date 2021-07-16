package com.example.binettest.mvi.states

sealed class EntryListViewState {
    object ListLoaded: EntryListViewState()
    object ListFailed: EntryListViewState()
}