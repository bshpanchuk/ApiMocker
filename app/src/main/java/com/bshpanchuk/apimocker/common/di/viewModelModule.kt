package com.bshpanchuk.apimocker.common.di

import com.bshpanchuk.apimocker.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}