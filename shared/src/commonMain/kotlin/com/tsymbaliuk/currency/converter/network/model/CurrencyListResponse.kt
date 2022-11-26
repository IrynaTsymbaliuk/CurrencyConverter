package com.tsymbaliuk.currency.converter.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.tsymbaliuk.currency.converter.model.Currency

/**
 * Network representation of [Currency] list
 */
@Serializable
data class CurrencyListResponse(

    @SerialName("success")
    val success: Boolean,

    @SerialName("currencies")
    val currencies: Map<String, String>?
)

fun CurrencyListResponse.asExternalModel(): List<Currency> {
    return currencies?.map { Currency(it.key, it.value) } ?: emptyList()
}