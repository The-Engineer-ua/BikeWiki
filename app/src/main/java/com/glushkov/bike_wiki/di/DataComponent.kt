package com.glushkov.bike_wiki.di

import com.glushkov.bike_wiki.di.module.ServiceModule
import com.glushkov.bike_wiki.service.GraphQlService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ServiceModule::class
])
interface DataComponent {
    fun getGraphQlService(): GraphQlService
}