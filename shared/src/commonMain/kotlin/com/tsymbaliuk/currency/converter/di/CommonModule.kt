package com.tsymbaliuk.currency.converter.di

import com.tsymbaliuk.currency.converter.network.datasource.FirebaseNetworkDataSource
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

/**
 * Header key for access to CurrencyLayer API
 */
private const val HEADER_KEY = "apikey"

class CommonModule {

    fun providesHttpClient(): HttpClient {
        return HttpClient {
            defaultRequest {
                header(HEADER_KEY, FirebaseNetworkDataSource().getApiKey())
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