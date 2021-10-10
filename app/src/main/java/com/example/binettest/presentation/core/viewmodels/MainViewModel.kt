package com.example.binettest.presentation.core.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.binettest.domain.entry_list.repositories.IBnetRepository
import com.example.binettest.domain.entry_list.repositories.IAppPreference
import com.example.binettest.presentation.base.viewmodel.BaseViewModel
import com.example.binettest.presentation.base.viewstate.BaseViewState
import com.example.binettest.presentation.core.action.ActivityAction
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(
        private val repository: IBnetRepository,
        private val appPreference: IAppPreference
): BaseViewModel<BaseViewState<String>, ActivityAction>() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    fun getSession(): String? {
        return appPreference.getSessionValue()
    }

    fun setSession() {
        try {
            disposable.add(
                getObservable()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableObserver<String>() {
                        override fun onComplete() {
                            Log.e(TAG, "onComplete()")
                        }

                        override fun onError(e: Throwable) {
                            Log.e(TAG, "onError()", e)
                        }

                        override fun onNext(t: String?) {
                            Log.e(TAG, "onNext")
                            if (t != null) {
                                appPreference.setSessionValue(t)
                            }
                        }
                    })
            )
        } catch (e: Exception) {
            Log.e("DAMN", e.toString())
        }
    }

    private fun getObservable(): Observable<String> {
        return Observable.defer {
            Observable.just(repository.getSessionValueApi())
        }
    }

    override fun handleAction(action: BaseViewState<String>) {
    }
}