package com.tsymbaliuk.currency.converter.network.datasource

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig

actual class FirebaseNetworkDataSource {

    init {
        Firebase.remoteConfig.fetchAndActivate()
    }

    actual fun getApiKey(parameterName: String): String {
        return Firebase.remoteConfig.getString(parameterName)
    }

}