package com.glushkov.bike_wiki.di

import com.glushkov.bike_wiki.di.module.ContextModule
import com.glushkov.bike_wiki.di.module.ServiceModule
import com.glushkov.bike_wiki.di.module.ToolsModule
import com.glushkov.bike_wiki.di.module.UiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    UiModule::class,
    ToolsModule::class,
    ServiceModule::class,
    ContextModule::class
])
interface ApplicationComponent {

    //fun inject(fragment: FeedFragment)
}