package com.tsymbaliuk.currency.converter.usecase

import com.tsymbaliuk.currency.converter.repository.CurrencyRepository
import com.tsymbaliuk.currency.converter.repository.FakeCurrencyRepositoryImpl

class UseCaseProvider {

    private val currencyRepository: CurrencyRepository = FakeCurrencyRepositoryImpl()

    val getCurrencyList: GetCurrencyList
        get() = GetCurrencyList(currencyRepository)

}