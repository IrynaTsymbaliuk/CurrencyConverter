package com.tsymbaliuk.currency.converter.usecase

import com.tsymbaliuk.currency.converter.model.Currency
import com.tsymbaliuk.currency.converter.repository.CurrencyRepository

/**
 * This use case fetches a full list of supported currencies
 */
class GetCurrencyList(private val repository: CurrencyRepository) {

    suspend operator fun invoke(): List<Currency> {
        return repository.currencyList()
    }

}