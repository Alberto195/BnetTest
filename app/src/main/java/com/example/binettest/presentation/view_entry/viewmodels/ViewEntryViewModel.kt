package com.example.binettest.presentation.view_entry.viewmodels

import com.example.binettest.domain.view_entry.models.EntryDetailsModel
import com.example.binettest.domain.view_entry.usecases.GetEntryDetailsUseCase
import com.example.binettest.presentation.base.viewmodel.BaseViewModel
import com.example.binettest.presentation.base.viewstate.BaseViewState
import com.example.binettest.presentation.view_entry.actions.ViewEntryAction

class ViewEntryViewModel(
    private val entryDetailsUseCase: GetEntryDetailsUseCase
) : BaseViewModel<ViewEntryAction, BaseViewState<*>>() {

    override fun handleAction(action: ViewEntryAction) {}

    fun getWholeEntry(): EntryDetailsModel {
        return entryDetailsUseCase.execute()
    }
}