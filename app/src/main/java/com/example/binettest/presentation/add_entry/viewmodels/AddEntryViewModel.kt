package com.example.binettest.presentation.add_entry.viewmodels

import android.util.Log
import com.example.binettest.domain.add_entry.models.AddEntryModel
import com.example.binettest.domain.add_entry.usecases.AddEntryUseCase
import com.example.binettest.presentation.add_entry.actions.AddEntryAction
import com.example.binettest.presentation.add_entry.viewstates.AddEntryViewState
import com.example.binettest.presentation.base.viewmodel.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers


class AddEntryViewModel(
    private val addEntry: AddEntryUseCase
) : BaseViewModel<AddEntryAction, AddEntryViewState>() {

    companion object {
        const val TAG = "AddEntryViewModel"
    }

    override fun handleAction(action: AddEntryAction) {
        when(action){
            is AddEntryAction.SaveClicked -> {
                saveClicked(action)
            }
            is AddEntryAction.BackClicked -> {
                backClicked()
            }
        }
    }

    private fun saveClicked(action: AddEntryAction.SaveClicked) {
        try {
            disposable.add(
                getObservable(action)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableObserver<Unit?>() {
                        override fun onComplete() {
                            Log.d(TAG, "onComplete()")
                            postValue(AddEntryViewState.AddSuccessful)
                        }

                        override fun onError(e: Throwable) {
                            Log.e(TAG, "onError()", e)
                            postValue(AddEntryViewState.AddFailed)
                        }

                        override fun onNext(t: Unit?) {
                            Log.e(TAG, "onNext()")
                        }
                    })
            )
        } catch (e: Exception) {
            postValue(AddEntryViewState.AddFailed)
        }
    }

    private fun backClicked() {
        try {
            postValue(AddEntryViewState.CleanSuccessful)
        } catch (e: Exception) {
            postValue(AddEntryViewState.CleanFailed)
        }
    }

    private fun getObservable(action: AddEntryAction.SaveClicked): Observable<Unit?> {
        return Observable.defer {
            Observable.just(addEntry.execute(
                    AddEntryModel(bodyText = action.body)
            ))
        }
    }
}