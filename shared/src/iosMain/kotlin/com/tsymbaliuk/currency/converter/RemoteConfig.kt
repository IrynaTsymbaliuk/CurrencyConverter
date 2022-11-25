package com.tsymbaliuk.currency.converter

actual class RemoteConfig {

    actual fun getApiKey(parameterName: String): String {
        return "test"
    }

}