package com.tsymbaliuk.currency.converter

object NetworkConstants {

    // Parameter name for CurrencyLayer API key  in Firebase Remote Config
    const val FIREBASE_REMOTE_CONFIG_API_KEY = "API_KEY"

    /**
     * Header key for access to CurrencyLayer API
     */
    const val HEADER_KEY = "apikey"

    /**
     * URL paths for CurrencyLayer API work
     */
    private const val BASE_URL = "https://api.apilayer.com/currency_data/"
    const val CURRENCY_LIST_PATH = BASE_URL + "list"

}