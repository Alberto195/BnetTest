package com.example.binettest.viewmodels

import androidx.lifecycle.ViewModel
import com.example.binettest.repository.localRepo.ILocalRepo
import com.example.binettest.repository.localRepo.LocalRepo

class WholeEntryViewModel(
        private val localRepository: ILocalRepo = LocalRepo(),
): ViewModel() {

    fun getDA(): String? {
        return localRepository.dateAdded
    }

    fun getDM(): String? {
        return localRepository.dateModified
    }

    fun getText(): String? {
        return localRepository.bodyText
    }

    fun setDA(da: String?) {
        localRepository.dateAdded = da
    }

    fun setDM(dm: String?) {
        localRepository.dateAdded = dm
    }

    fun setText(text: String?) {
        localRepository.dateAdded = text
    }
}
