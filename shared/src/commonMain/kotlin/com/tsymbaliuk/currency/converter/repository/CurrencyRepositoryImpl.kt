package com.tsymbaliuk.currency.converter.repository

import com.tsymbaliuk.currency.converter.model.Currency
import com.tsymbaliuk.currency.converter.network.datasource.KtorNetworkDataSource
import com.tsymbaliuk.currency.converter.network.model.asExternalModel

class CurrencyRepositoryImpl : CurrencyRepository {

    private val currencyService = KtorNetworkDataSource()

    override suspend fun currencyList(): List<Currency> {
        return currencyService.getCurrencyList().asExternalModel()
    }

}