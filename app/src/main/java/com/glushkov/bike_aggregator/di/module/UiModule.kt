package com.glushkov.bike_aggregator.di.module

import com.glushkov.bike_aggregator.tools.UiHelper
import dagger.Module
import dagger.Provides

@Module
class UiModule {

    //@Provides
    //fun getFeedAdapter() : FeedRecyclerAdapter {
        //return FeedRecyclerAdapter()
    //}

    @Provides
    fun getUiHelper() : UiHelper {
        return UiHelper()
    }
}