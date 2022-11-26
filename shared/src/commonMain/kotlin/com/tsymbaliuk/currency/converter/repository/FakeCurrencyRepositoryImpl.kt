package com.tsymbaliuk.currency.converter.repository

import com.tsymbaliuk.currency.converter.model.Currency

class FakeCurrencyRepositoryImpl : CurrencyRepository {

    override suspend fun currencyList(): List<Currency> {
        return listOf(
            Currency(
                code = "AED",
                name = "United Arab Emirates Dirham"
            ),
            Currency(
                code = "AFN",
                name = "Afghan Afghani"
            ),
            Currency(
                code = "ALL",
                name = "Albanian Lek"
            ),
            Currency(
                code = "AMD",
                name = "Armenian Dram"
            )
        )
    }

}