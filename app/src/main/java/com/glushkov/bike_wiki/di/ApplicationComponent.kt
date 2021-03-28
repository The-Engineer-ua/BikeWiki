package com.glushkov.bike_wiki.di

import android.content.Context
import com.glushkov.bike_wiki.data.AppLocalRepository
import com.glushkov.bike_wiki.di.module.ContextModule
import com.glushkov.bike_wiki.di.module.ServiceModule
import com.glushkov.bike_wiki.di.module.DataModule
import com.glushkov.bike_wiki.service.GraphQlService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataModule::class,
    ServiceModule::class,
    ContextModule::class
])
interface ApplicationComponent {
    fun getContext(): Context

    fun getGraphQlService(): GraphQlService

    fun getLocalRepository(): AppLocalRepository
}