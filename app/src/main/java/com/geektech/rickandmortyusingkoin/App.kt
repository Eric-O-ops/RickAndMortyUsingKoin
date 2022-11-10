package com.geektech.rickandmortyusingkoin

import android.app.Application
import com.geektech.rickandmortyusingkoin.di.appModule
import com.geektech.rickandmortyusingkoin.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            modules(appModule, dataModule)
        }
    }
}