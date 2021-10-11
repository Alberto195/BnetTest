package com.example.binettest.presentation.core.di

import com.example.binettest.domain.core.usecases.GetSessionValueUseCase
import com.example.binettest.domain.core.usecases.GetUserSessionIdUseCase
import com.example.binettest.domain.core.usecases.SetUserSessionUseCase
import com.example.binettest.presentation.core.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelCoreModule: Module = module {
    viewModel { MainViewModel(get(), get(), get()) }
}

val useCasesCoreModule: Module = module {
    factory { GetSessionValueUseCase(get()) }

    factory { GetUserSessionIdUseCase(get()) }

    factory { SetUserSessionUseCase(get()) }
}