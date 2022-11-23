package com.tsymbaliuk.currency.converter

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

actual class RemoteConfig {

    actual fun getApiKey(): Flow<String> {
        return callbackFlow {
            trySend("test")
            awaitClose { channel.close() }
        }
    }

}