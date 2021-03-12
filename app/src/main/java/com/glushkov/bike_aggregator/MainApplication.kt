package com.glushkov.bike_aggregator

import android.app.Application
import com.glushkov.bike_aggregator.di.ApplicationComponent
import com.glushkov.bike_aggregator.di.DaggerApplicationComponent

class MainApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}