package com.tsymbaliuk.currency.converter.di

import com.tsymbaliuk.currency.converter.network.datasource.FirebaseNetworkDataSource
import com.tsymbaliuk.currency.converter.network.datasource.KtorNetworkDataSource
import com.tsymbaliuk.currency.converter.network.datasource.NetworkDataSource
import com.tsymbaliuk.currency.converter.repository.CurrencyRepository
import com.tsymbaliuk.currency.converter.repository.CurrencyRepositoryImpl
import com.tsymbaliuk.currency.converter.usecase.UseCaseProvider
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import org.koin.dsl.module

/**
 * Header key for access to CurrencyLayer API
 */
private const val HEADER_KEY = "apikey"

val commonModule = module {

    single {
        HttpClient {
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

    single<NetworkDataSource> { KtorNetworkDataSource(get()) }

    single<CurrencyRepository> { CurrencyRepositoryImpl(get()) }

    factory {
        UseCaseProvider()
    }

}