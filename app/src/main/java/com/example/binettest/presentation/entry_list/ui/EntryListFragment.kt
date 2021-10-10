package com.example.binettest.presentation.entry_list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.binettest.R
import com.example.binettest.presentation.base.ui.BaseFragment
import com.example.binettest.databinding.EntryListFragmentBinding
import com.example.binettest.presentation.entry_list.action.EntryListAction
import com.example.binettest.presentation.entry_list.adapters.EntryListAdapter
import com.example.binettest.presentation.entry_list.viewstate.EntryListViewState
import com.example.binettest.presentation.entry_list.viewmodels.EntryListViewModel
import kotlin.reflect.KClass

class EntryListFragment: BaseFragment<
        EntryListViewState,
        EntryListAction,
        EntryListViewModel,
        EntryListFragmentBinding
        >(), EntryListAdapter.EntryHolder.Listener
{
    private lateinit var listAdapter: EntryListAdapter

    override fun getViewModelClass(): KClass<EntryListViewModel> = EntryListViewModel::class

    override fun getBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): EntryListFragmentBinding =
        EntryListFragmentBinding.inflate(
            inflater,
            container,
            false
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter = EntryListAdapter(this)

        binding.recycler.apply {
            layoutManager = GridLayoutManager(context, 1)
            adapter = listAdapter
        }
        binding.showList.setOnClickListener {
            dispatchAction(EntryListAction.ShowClicked)
        }
    }

    override fun render(viewState: EntryListViewState) {
        when(viewState) {
            is EntryListViewState.ListFailed -> loadListFailed()
            is EntryListViewState.ListLoaded -> showList()
        }
    }

    private fun loadListFailed() {
        Toast.makeText(
            requireContext(),
            "Ошибка! Проверьте соединение",
            Toast.LENGTH_LONG).show()
    }

    private fun showList() {
        viewModel.getEntry()?.let { listAdapter.setList(it) }
    }

    override fun onClick(dateAdded: String, dateModified: String, bodyText: String) {
        goWholeEntryFragment(dateAdded, dateModified, bodyText)
    }

    private fun goWholeEntryFragment(dateAdded: String, dateModified: String, bodyText: String) {
        val bundle = Bundle()
        bundle.putString("dateAdded", dateAdded)
        bundle.putString("dateModified", dateModified)
        bundle.putString("bodyText", bodyText)

        Navigation.findNavController(requireActivity(), R.id.fragment_container)
            .navigate(R.id.action_entryListFragment_to_wholeEntryFragment, bundle)
    }
}
