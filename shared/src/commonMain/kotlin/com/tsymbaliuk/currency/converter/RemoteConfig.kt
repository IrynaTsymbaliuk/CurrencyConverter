package com.tsymbaliuk.currency.converter

import kotlinx.coroutines.flow.Flow

expect class RemoteConfig() {

    fun getApiKey(): Flow<String>

}

