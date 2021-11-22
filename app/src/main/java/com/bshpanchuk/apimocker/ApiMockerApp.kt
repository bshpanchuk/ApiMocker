package com.bshpanchuk.apimocker

import android.app.Application
import com.bshpanchuk.apimocker.common.*
import com.bshpanchuk.apimocker.common.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApiMockerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ApiMockerApp)
            modules(
                applicationModule,
                viewModelModule,
                dataModule,
                networkModule
            )
        }
    }
}