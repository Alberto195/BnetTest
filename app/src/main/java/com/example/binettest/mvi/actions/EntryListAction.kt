package com.example.binettest.mvi.actions

sealed class EntryListAction {
    object ShowClicked : EntryListAction()
}