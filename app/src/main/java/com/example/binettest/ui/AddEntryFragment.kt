package com.example.binettest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.binettest.base.BaseFragment
import com.example.binettest.databinding.AddEntryFragmentBinding
import com.example.binettest.mvi.actions.AddEntryAction
import com.example.binettest.mvi.states.AddEntryViewState
import com.example.binettest.viewmodels.AddEntryViewModel
import kotlin.reflect.KClass

class AddEntryFragment : BaseFragment<
        AddEntryViewState,
        AddEntryAction,
        AddEntryViewModel,
        AddEntryFragmentBinding
        >()
{
    override fun getViewModelClass(): KClass<AddEntryViewModel> = AddEntryViewModel::class

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AddEntryFragmentBinding =
        AddEntryFragmentBinding.inflate(
            inflater,
            container,
            false
        )

    override fun render(viewState: AddEntryViewState) {
        when(viewState) {
            is AddEntryViewState.AddFailed -> addingEntryFailed()
            is AddEntryViewState.AddSuccessful -> addingEntrySuccessful()
            is AddEntryViewState.CleanFailed -> cleaningBodyFailed()
            is AddEntryViewState.CleanSuccessful -> cleaningBodySuccessful()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.add.setOnClickListener {
            dispatchAction(AddEntryAction.SaveClicked(
                binding.entryBody.text.toString()
            ))
        }
        binding.back.setOnClickListener {
            dispatchAction(AddEntryAction.BackClicked(
                binding.entryBody.text.toString()
            ))
        }
    }

    private fun addingEntryFailed() {
        Toast.makeText(
            requireContext(),
            "Запись НЕ добавлена! Проверьте соединение!",
            Toast.LENGTH_LONG).show()
    }

    private fun addingEntrySuccessful() {
        Toast.makeText(requireContext(), "Запись добавлена!", Toast.LENGTH_LONG).show()
    }

    private fun cleaningBodyFailed() {
        Toast.makeText(requireContext(), "Запись не очистена!", Toast.LENGTH_LONG).show()
    }

    private fun cleaningBodySuccessful() {
        binding.entryBody.text.clear()
        Toast.makeText(requireContext(), "Запись очистена!", Toast.LENGTH_LONG).show()
    }
}
