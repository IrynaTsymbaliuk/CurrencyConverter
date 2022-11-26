package com.tsymbaliuk.currency.converter.repository

import com.tsymbaliuk.currency.converter.model.Currency

interface CurrencyRepository {

    suspend fun currencyList(): List<Currency>

}