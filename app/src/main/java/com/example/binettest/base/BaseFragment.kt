package com.example.binettest.base

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.koin.getViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.java.KoinJavaComponent.getKoin
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseFragment<
        ViewState,
        Action,
        ViewModel : BaseViewModel<Action, ViewState>,
        Binding : ViewBinding
        >: Fragment(), BaseView<ViewState> {
    lateinit var viewModel: ViewModel
    protected lateinit var binding: Binding

    abstract fun getViewModelClass(): KClass<ViewModel>
    protected abstract fun getBinding(inflater: LayoutInflater, container: ViewGroup?): Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = getViewModel(clazz = getViewModelClass())
        binding = getBinding(
            inflater = inflater,
            container = container
        )
        viewModel.publicViewState.observe(viewLifecycleOwner) {
            renderViewState(it)
        }
        return binding.root
    }

    private fun renderViewState(viewState: BaseViewState<ViewState>) {
        when(viewState){
            is BaseViewState.Message -> showErrorMessage(viewState.message)

            is BaseViewState.Error -> showFatalError(viewState.throwable)

            is BaseViewState.Loading -> showLoading()

            is BaseViewState.Other<ViewState> -> {
                render(viewState.content)
            }
        }
    }

    protected fun dispatchAction(action: Action) = viewModel.dispatch(action)

    private fun showErrorMessage(error: String){
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    private fun showFatalError(error: Throwable){
        Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun showLoading(){
        Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
    }
}