package com.tsymbaliuk.currency.converter.network.datasource

import com.tsymbaliuk.currency.converter.network.model.CurrencyListResponse

interface NetworkDataSource {

    suspend fun getCurrencyList(): CurrencyListResponse

}