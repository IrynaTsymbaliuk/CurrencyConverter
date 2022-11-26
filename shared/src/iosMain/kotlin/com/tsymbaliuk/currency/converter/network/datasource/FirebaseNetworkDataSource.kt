package com.tsymbaliuk.currency.converter.network.datasource

actual class FirebaseNetworkDataSource {

    actual fun getApiKey(parameterName: String): String {
        return "test"
    }

}