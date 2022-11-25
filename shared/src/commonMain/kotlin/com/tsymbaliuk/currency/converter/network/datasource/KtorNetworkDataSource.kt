package com.tsymbaliuk.currency.converter.network.datasource

import com.tsymbaliuk.currency.converter.NetworkConstants.CURRENCY_LIST_PATH
import com.tsymbaliuk.currency.converter.di.CommonModule
import com.tsymbaliuk.currency.converter.network.model.CurrencyListResponse
import io.ktor.client.request.*

/**
 * A full list of supported currencies can be accessed both in JSON Format.
 * Example API Response:
 * {
 *  "success": true,
 *  "currencies": {
 *      "AED": "United Arab Emirates Dirham",
 *      "AFN": "Afghan Afghani",
 *      "ALL": "Albanian Lek",
 *      "AMD": "Armenian Dram",
 *      "ANG": "Netherlands Antillean Guilder",
 *      [...]
 *  }
 * }
 *
 * More: https://currencylayer.com/documentation
 */

class KtorNetworkDataSource {

    private val client = CommonModule().providesHttpClient()

    suspend fun getCurrencyList(): CurrencyListResponse {
        return client.get {
            url(CURRENCY_LIST_PATH)
        }
    }

}