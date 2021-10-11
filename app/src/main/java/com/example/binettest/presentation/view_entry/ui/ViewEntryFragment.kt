package com.example.binettest.presentation.view_entry.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.binettest.databinding.FragmentViewEntryBinding
import com.example.binettest.presentation.base.ui.BaseFragment
import com.example.binettest.presentation.base.viewstate.BaseViewState
import com.example.binettest.presentation.view_entry.actions.ViewEntryAction
import com.example.binettest.presentation.view_entry.viewmodels.ViewEntryViewModel
import kotlin.reflect.KClass

class ViewEntryFragment : BaseFragment<
        BaseViewState<*>,
        ViewEntryAction,
        ViewEntryViewModel,
        FragmentViewEntryBinding
        >() {

    override fun getViewModelClass(): KClass<ViewEntryViewModel> = ViewEntryViewModel::class

    override fun getBinding(
            inflater: LayoutInflater,
            container: ViewGroup?
    ): FragmentViewEntryBinding =
            FragmentViewEntryBinding.inflate(
                    inflater,
                    container,
                    false
            )

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTexts()
    }

    private fun setTexts() {
        viewModel.getWholeEntry().let {
            binding.da.text = it.dateAdded
            binding.dm.text = it.dateModified
            binding.bodyContent.text = it.bodyText
        }
    }

    override fun render(viewState: BaseViewState<*>) {
    }
}