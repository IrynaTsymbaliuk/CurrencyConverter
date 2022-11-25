package com.tsymbaliuk.currency.converter.usecase

import com.tsymbaliuk.currency.converter.repository.CurrencyRepository

class UseCaseProvider(
    private val currencyRepository: CurrencyRepository
) {

    val getCurrencyList: GetCurrencyList
        get() = GetCurrencyList(currencyRepository)

}