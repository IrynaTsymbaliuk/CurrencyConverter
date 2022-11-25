package com.tsymbaliuk.currency.converter

expect class RemoteConfig() {

    fun getApiKey(parameterName: String = NetworkConstants.FIREBASE_REMOTE_CONFIG_API_KEY): String

}

