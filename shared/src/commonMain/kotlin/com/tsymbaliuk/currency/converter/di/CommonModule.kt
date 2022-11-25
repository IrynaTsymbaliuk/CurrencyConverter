package com.tsymbaliuk.currency.converter.di

import com.tsymbaliuk.currency.converter.NetworkConstants
import com.tsymbaliuk.currency.converter.RemoteConfig
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

class CommonModule {

    fun providesHttpClient(): HttpClient {
        return HttpClient {
            defaultRequest {
                header(NetworkConstants.HEADER_KEY, RemoteConfig().getApiKey())
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 6_000
                requestTimeoutMillis = 6_000
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

}