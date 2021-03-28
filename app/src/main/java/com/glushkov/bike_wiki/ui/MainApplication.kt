package com.glushkov.bike_wiki.ui

import android.app.Application
import com.glushkov.bike_wiki.data.AppLocalRepository
import com.glushkov.bike_wiki.di.ApplicationComponent
import com.glushkov.bike_wiki.di.DaggerApplicationComponent
import com.glushkov.bike_wiki.di.module.ContextModule

class MainApplication : Application() {
    companion object {
        var instance: MainApplication? = null
            private set
    }

    private lateinit var appComponent: ApplicationComponent

    lateinit var localData: AppLocalRepository

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .contextModule(ContextModule(this)).build()
        localData = appComponent.getLocalRepository()

        instance = this
    }
}