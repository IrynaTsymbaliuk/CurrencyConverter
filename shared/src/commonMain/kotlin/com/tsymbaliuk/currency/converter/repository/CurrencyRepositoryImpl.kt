package com.tsymbaliuk.currency.converter.repository

import com.tsymbaliuk.currency.converter.model.Currency
import com.tsymbaliuk.currency.converter.network.datasource.KtorNetworkDataSource
import com.tsymbaliuk.currency.converter.network.model.asExternalModel

class CurrencyRepositoryImpl(private val currencyService: KtorNetworkDataSource) :
    CurrencyRepository {

    override suspend fun currencyList(): List<Currency> {
        return currencyService.getCurrencyList().asExternalModel()
    }

}