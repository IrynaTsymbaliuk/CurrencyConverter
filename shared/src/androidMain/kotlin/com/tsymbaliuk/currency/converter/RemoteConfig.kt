package com.tsymbaliuk.currency.converter

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.tsymbaliuk.currency.converter.NetworkConstants.FIREBASE_REMOTE_CONFIG_API_KEY
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

actual class RemoteConfig {

    actual fun getApiKey(): Flow<String> {
        return callbackFlow {
            Firebase.remoteConfig.apply {
                fetchAndActivate().addOnCompleteListener {
                    if (it.isSuccessful) trySend(getString(FIREBASE_REMOTE_CONFIG_API_KEY))
                }
            }
            awaitClose { channel.close() }
        }
    }

}