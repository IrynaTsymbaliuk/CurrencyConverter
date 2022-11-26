package com.tsymbaliuk.currency.converter.android.home

import com.tsymbaliuk.currency.converter.android.mvi.base.ViewIntent
import com.tsymbaliuk.currency.converter.model.Currency

sealed class HomeIntent : ViewIntent {

    object GetCurrencyList : HomeIntent()
    data class SelectFromCurrency(val currency: Currency) : HomeIntent()
    object Swap : HomeIntent()
    data class SelectToCurrency(val currency: Currency) : HomeIntent()

}