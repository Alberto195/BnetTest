package com.example.binettest.viewmodels

import android.util.Log
import com.example.binettest.base.BaseViewModel
import com.example.binettest.models.GetEntriesModel
import com.example.binettest.mvi.actions.EntryListAction
import com.example.binettest.mvi.states.EntryListViewState
import com.example.binettest.repository.bnetRepo.BnetRepository
import com.example.binettest.repository.bnetRepo.IBnetRepository
import com.example.binettest.repository.preference.IAppPreference
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class EntryListViewModel(
        private val repository: IBnetRepository
) : BaseViewModel<EntryListAction, EntryListViewState>() {

    companion object {
        const val TAG = "EntryListViewModel"
    }

    private var entry: GetEntriesModel? = null

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
                    .subscribeWith(object : DisposableObserver<GetEntriesModel?>() {
                        override fun onComplete() {
                            Log.d(TAG, "onComplete()")
                            postValue(EntryListViewState.ListLoaded)
                        }

                        override fun onError(e: Throwable) {
                            Log.e(TAG, "onError()", e)
                            postValue(EntryListViewState.ListFailed)
                        }

                        override fun onNext(t: GetEntriesModel?) {
                            if (t?.status != 0) entry = t
                        }
                    })
            )
        } catch (e: Exception) {
            postValue(EntryListViewState.ListFailed)
        }
    }

    fun getEntry(): GetEntriesModel? {
        return entry
    }

    private fun getObservable(): Observable<GetEntriesModel?> {
        return Observable.defer {
            Observable.just(repository.getEntry())
        }
    }
}