package com.glushkov.bike_aggregator.di

import com.glushkov.bike_aggregator.di.module.ServiceModule
import com.glushkov.bike_aggregator.service.GraphQlService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ServiceModule::class
])
interface DataComponent {
    fun getGraphQlService(): GraphQlService
}