package com.kirill1995.kazzak.app

import android.app.Application
import com.kirill1995.kazzak.di.appModule
import com.kirill1995.kazzak.di.dataModule
import com.kirill1995.kazzak.di.domainModule
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() {
        startKoin {
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}