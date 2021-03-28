package com.glushkov.bike_wiki.di.module

import com.apollographql.apollo.ApolloClient
import com.glushkov.bike_wiki.BuildConfig
import com.glushkov.bike_wiki.data.BikeRemoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl(BuildConfig.API_URL)
            .build()
    }

    @Provides
    fun provideSpaceXDataSource(apolloClient: ApolloClient) : BikeRemoteRepository {
        return BikeRemoteRepository(apolloClient)
    }
}