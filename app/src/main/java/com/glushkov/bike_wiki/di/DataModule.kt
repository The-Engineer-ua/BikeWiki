package com.glushkov.bike_wiki.di

import com.glushkov.bike_wiki.data.AppLocalRepository
import com.glushkov.bike_wiki.tools.GsonHelper
import org.koin.dsl.module

val dataModule = module {
    single<GsonHelper> {
        GsonHelper(get())
    }

    single<AppLocalRepository> {
        AppLocalRepository(get())
    }
}