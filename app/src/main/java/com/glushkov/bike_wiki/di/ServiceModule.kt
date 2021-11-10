package com.glushkov.bike_wiki.di

import com.apollographql.apollo.ApolloClient
import com.glushkov.bike_wiki.BuildConfig
import com.glushkov.bike_wiki.data.BikeRemoteRepository
import com.glushkov.bike_wiki.service.GraphQlService
import org.koin.dsl.module

val serviceModule = module {
    single<ApolloClient> {
       ApolloClient.builder()
            .serverUrl(BuildConfig.API_URL)
            .build()
    }

    single<BikeRemoteRepository> {
        BikeRemoteRepository(get())
    }

    single<GraphQlService> {
        GraphQlService(get())
    }
}