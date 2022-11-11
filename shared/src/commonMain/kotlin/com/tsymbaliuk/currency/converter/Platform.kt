package com.tsymbaliuk.currency.converter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform