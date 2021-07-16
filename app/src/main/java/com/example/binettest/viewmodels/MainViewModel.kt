package com.example.binettest.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.binettest.repository.bnetRepo.BnetRepository
import com.example.binettest.repository.bnetRepo.IBnetRepository
import com.example.binettest.repository.preference.IAppPreference
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(
        private val repository: IBnetRepository,
        private val appPreference: IAppPreference
): ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    fun getSession(): String? {
        return appPreference.getSessionValue()
    }

    fun setSession() {
        try {
            val disposable = CompositeDisposable()
            disposable.add(
                getObservable()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableObserver<String>() {
                        override fun onComplete() {
                            Log.e(TAG, "onComplete()")
                        }

                        override fun onError(e: Throwable) {
                            Log.e(AddEntryViewModel.TAG, "onError()", e)
                        }

                        override fun onNext(t: String?) {
                            Log.e(AddEntryViewModel.TAG, "onNext")
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

    fun initPreference() {
        appPreference.initPreference()
    }

    private fun getObservable(): Observable<String> {
        return Observable.defer {
            Observable.just(repository.getSessionValueApi())
        }
    }
}