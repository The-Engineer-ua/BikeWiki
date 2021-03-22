package com.glushkov.bike_wiki

import android.app.Application
import com.glushkov.bike_wiki.di.ApplicationComponent
import com.glushkov.bike_wiki.di.DaggerApplicationComponent

class MainApplication : Application() {
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}