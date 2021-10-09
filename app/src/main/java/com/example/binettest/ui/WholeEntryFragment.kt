package com.example.binettest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.binettest.databinding.WholeEntryFragmentBinding
import com.example.binettest.viewmodels.WholeEntryViewModel

class WholeEntryFragment: Fragment() {

    private lateinit var binding: WholeEntryFragmentBinding
    private val viewModel = WholeEntryViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WholeEntryFragmentBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getBundle()
        binding.da.text = viewModel.getDA()
        binding.dm.text = viewModel.getDM()
        binding.bodyContent.text = viewModel.getText()
    }

    private fun getBundle() {
        viewModel.setDA(requireArguments().getString("dateAdded"))
        viewModel.setDM(requireArguments().getString("dateModified"))
        viewModel.setText(requireArguments().getString("bodyText"))

    }
}