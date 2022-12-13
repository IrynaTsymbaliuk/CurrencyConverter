package com.tsymbaliuk.currency.converter.android

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.tsymbaliuk.currency.converter.android.di.androidModule
import com.tsymbaliuk.currency.converter.di.commonModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initFirebase()
        initKoin()
    }

    private fun initFirebase() {
        Firebase.initialize(applicationContext)
    }

    private fun initKoin() {
        startKoin {
            modules(androidModule, commonModule)
        }
    }

}