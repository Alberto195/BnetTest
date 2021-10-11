package com.example.binettest.presentation.core.viewmodels

import android.util.Log
import com.example.binettest.domain.core.models.UserSessionId
import com.example.binettest.domain.core.usecases.GetUserSessionIdUseCase
import com.example.binettest.domain.core.usecases.GetNewSessionValueUseCase
import com.example.binettest.domain.core.usecases.SetUserSessionUseCase
import com.example.binettest.presentation.base.viewmodel.BaseViewModel
import com.example.binettest.presentation.base.viewstate.BaseViewState
import com.example.binettest.presentation.core.action.ActivityAction
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(
        private val getUserSessionIdUseCase: GetUserSessionIdUseCase,
        private val setUserSessionUseCase: SetUserSessionUseCase,
        private val getSessionValueUseCase: GetNewSessionValueUseCase
): BaseViewModel<BaseViewState<*>, ActivityAction>() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    fun getSession(): UserSessionId? {
        return getUserSessionIdUseCase.execute()
    }

    fun setSession() {
        try {
            disposable.add(
                getObservable()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableObserver<UserSessionId>() {
                        override fun onComplete() {
                            Log.e(TAG, "onComplete()")
                        }

                        override fun onError(e: Throwable) {
                            Log.e(TAG, "onError()", e)
                        }

                        override fun onNext(t: UserSessionId?) {
                            Log.e(TAG, "onNext")
                                setUserSessionUseCase.execute(t)

                        }
                    })
            )
        } catch (e: Exception) {
            Log.e("DAMN", e.toString())
        }
    }

    private fun getObservable(): Observable<UserSessionId> {
        return Observable.defer {
            Observable.just(getSessionValueUseCase.execute())
        }
    }

    override fun handleAction(action: BaseViewState<*>) {}
}