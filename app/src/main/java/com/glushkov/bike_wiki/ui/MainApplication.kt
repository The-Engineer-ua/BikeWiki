package com.glushkov.bike_wiki.ui

import android.app.Application
import com.glushkov.bike_wiki.di.dataModule
import com.glushkov.bike_wiki.di.serviceModule
import com.glushkov.bike_wiki.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //DI init. Inline cause nothing more here expected.
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(
                dataModule,
                serviceModule,
                viewModule
            ))
        }
    }
}