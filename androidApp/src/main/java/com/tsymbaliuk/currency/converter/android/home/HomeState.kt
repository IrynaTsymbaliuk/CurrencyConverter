package com.tsymbaliuk.currency.converter.android.home

import com.tsymbaliuk.currency.converter.android.mvi.base.ViewState
import com.tsymbaliuk.currency.converter.model.Currency

data class HomeState(
    val isLoading: Boolean = false,
    val currencyList: List<Currency> = emptyList(),
    val fromCurrency: Currency? = null,
    val toCurrency: Currency? = null
) : ViewState