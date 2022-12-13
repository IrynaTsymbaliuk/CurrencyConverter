package com.tsymbaliuk.currency.converter.android.di

import com.tsymbaliuk.currency.converter.android.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {

    viewModel { HomeViewModel(get()) }

}