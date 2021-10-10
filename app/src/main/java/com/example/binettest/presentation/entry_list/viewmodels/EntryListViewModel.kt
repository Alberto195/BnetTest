package com.example.binettest.presentation.entry_list.viewmodels

import android.util.Log
import com.example.binettest.presentation.base.viewmodel.BaseViewModel
import com.example.binettest.domain.entry_list.models.EntryListModel
import com.example.binettest.domain.entry_list.repositories.IBnetRepository
import com.example.binettest.presentation.entry_list.action.EntryListAction
import com.example.binettest.presentation.entry_list.viewstate.EntryListViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class EntryListViewModel(
        private val repository: IBnetRepository
) : BaseViewModel<EntryListAction, EntryListViewState>() {

    companion object {
        const val TAG = "EntryListViewModel"
    }

    private var entry: List<EntryListModel?>? = null

    override fun handleAction(action: EntryListAction) {
        when(action) {
            is EntryListAction.ShowClicked -> {
                getEntryList()
            }
        }
    }

    private fun getEntryList() {
        try {
            disposable.add(
                getObservable()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableObserver<Single<List<EntryListModel?>>> () {
                        override fun onComplete() {
                            Log.d(TAG, "onComplete()")
                            postValue(EntryListViewState.ListLoaded)
                        }

                        override fun onError(e: Throwable) {
                            Log.e(TAG, "onError()", e)
                            postValue(EntryListViewState.ListFailed)
                        }

                        override fun onNext(t: Single<List<EntryListModel?>>?) {
                            if (t?.status != 0) entry = t.blockingGet()
                        }
                    })
            )
        } catch (e: Exception) {
            postValue(EntryListViewState.ListFailed)
        }
    }

    fun getEntry(): List<EntryListModel?>? {
        return entry
    }

    private fun getObservable(): Observable<Single<List<EntryListModel?>>> {
        return Observable.defer {
            Observable.just(repository.getEntry())
        }
    }
}