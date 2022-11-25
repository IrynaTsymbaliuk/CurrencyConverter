package com.tsymbaliuk.currency.converter.network.datasource

/**
 * Parameter name for CurrencyLayer API key  in Firebase Remote Config
 */
private const val FIREBASE_REMOTE_CONFIG_PARAMETER_NAME = "API_KEY"

expect class FirebaseNetworkDataSource() {

    fun getApiKey(parameterName: String = FIREBASE_REMOTE_CONFIG_PARAMETER_NAME): String

}