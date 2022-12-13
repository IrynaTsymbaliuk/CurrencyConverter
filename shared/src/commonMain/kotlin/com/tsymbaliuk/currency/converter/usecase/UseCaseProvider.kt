package com.tsymbaliuk.currency.converter.usecase

import com.tsymbaliuk.currency.converter.repository.CurrencyRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class UseCaseProvider : KoinComponent {

    private val currencyRepository: CurrencyRepository by inject()

    val getCurrencyList: GetCurrencyList
        get() = GetCurrencyList(currencyRepository)

}