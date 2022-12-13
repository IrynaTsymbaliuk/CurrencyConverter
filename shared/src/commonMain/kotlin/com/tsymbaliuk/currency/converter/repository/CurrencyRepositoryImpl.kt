package com.tsymbaliuk.currency.converter.repository

import com.tsymbaliuk.currency.converter.model.Currency
import com.tsymbaliuk.currency.converter.network.datasource.NetworkDataSource
import com.tsymbaliuk.currency.converter.network.model.asExternalModel

class CurrencyRepositoryImpl(
    private val service: NetworkDataSource,
) : CurrencyRepository {

    override suspend fun currencyList(): List<Currency> {
        return service.getCurrencyList().asExternalModel()
    }

}