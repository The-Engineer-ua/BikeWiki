package com.glushkov.bike_wiki.di.module

import android.content.Context
import com.glushkov.bike_wiki.data.AppLocalRepository
import com.glushkov.bike_wiki.tools.GsonHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module (includes = [ContextModule::class])
class DataModule {
    @Singleton
    @Provides
    fun getGsonHelper(context: Context) : GsonHelper {
        return GsonHelper(context)
    }

    @Singleton
    @Provides
    fun getLocalRepository(gsonHelper: GsonHelper) : AppLocalRepository {
        return AppLocalRepository(gsonHelper)
    }
}