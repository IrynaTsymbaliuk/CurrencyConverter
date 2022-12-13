package com.tsymbaliuk.currency.converter.network.datasource

import com.tsymbaliuk.currency.converter.network.model.CurrencyListResponse
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * URL paths for CurrencyLayer API work
 */
private const val BASE_URL = "https://api.apilayer.com/currency_data/"
private const val CURRENCY_LIST_PATH = BASE_URL + "list"

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

class KtorNetworkDataSource(
    private val client: HttpClient,
) : NetworkDataSource {

    override suspend fun getCurrencyList(): CurrencyListResponse {
        return client.get {
            url(CURRENCY_LIST_PATH)
        }
    }

}