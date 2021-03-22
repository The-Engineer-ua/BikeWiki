package com.glushkov.bike_wiki.di.module

import android.content.Context
import com.glushkov.bike_wiki.tools.DataHelper
import com.glushkov.bike_wiki.tools.GsonHelper
import dagger.Module
import dagger.Provides

@Module (includes = [ContextModule::class])
class ToolsModule {
    @Provides
    fun getGsonHelper(context: Context) : GsonHelper {
        return GsonHelper(context)
    }

    @Provides
    fun getDataHelper(gsonHelper: GsonHelper) : DataHelper {
        return DataHelper(gsonHelper)
    }
}