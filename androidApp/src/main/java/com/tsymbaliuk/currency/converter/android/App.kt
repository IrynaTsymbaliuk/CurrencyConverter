package com.tsymbaliuk.currency.converter.android

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(applicationContext)
    }

}