package com.example.binettest.presentation.entry_list.viewmodels

import android.util.Log
import com.example.binettest.domain.entry_list.models.EntryListModel
import com.example.binettest.domain.entry_list.usecases.GetEntryListUseCase
import com.example.binettest.domain.entry_list.usecases.SetViewEntryUseCase
import com.example.binettest.presentation.base.viewmodel.BaseViewModel
import com.example.binettest.presentation.entry_list.action.EntryListAction
import com.example.binettest.presentation.entry_list.viewstate.EntryListViewState
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class EntryListViewModel(
    private val entryListUseCase: GetEntryListUseCase,
    private val setViewEntry: SetViewEntryUseCase
) : BaseViewModel<EntryListAction, EntryListViewState>() {

    companion object {
        const val TAG = "EntryListViewModel"
    }

    private var entry: List<EntryListModel?>? = null

    override fun handleAction(action: EntryListAction) {
        when (action) {
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
                    .subscribeWith(object : DisposableObserver<List<EntryListModel?>>() {
                        override fun onComplete() {
                            Log.d(TAG, "onComplete()")
                            postValue(EntryListViewState.ListLoaded)
                        }

                        override fun onError(e: Throwable) {
                            Log.e(TAG, "onError()", e)
                            postValue(EntryListViewState.ListFailed)
                        }

                        override fun onNext(t: List<EntryListModel?>?) {
                            entry = t
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

    fun setViewEntry(entry: EntryListModel?) {
        disposable.add(
            Observable.defer {
                Observable.just(setViewEntry.execute(entry))
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<Unit>() {
                    override fun onNext(t: Unit?) {
                    }

                    override fun onError(e: Throwable?) {
                    }

                    override fun onComplete() {

                    }

                })
        )

    }

    private fun getObservable(): Observable<List<EntryListModel?>> {
        return Observable.defer {
            Observable.just(entryListUseCase.execute())
        }
    }
}