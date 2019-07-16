package com.example.football_exp.core.di

import com.example.football_exp.data.data_source.FootballDataFromDatabase
import com.example.football_exp.data.data_source.FootballDataFromDatabaseImpl
import com.example.football_exp.data.data_source.FootballDataFromNetwork
import com.example.football_exp.data.data_source.FootballDataFromNetworkImpl
import com.example.football_exp.data.football_repos.*
import com.example.football_exp.data.network.FootballDataAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class FootballDataModule{

    @Provides
    fun provideFootballDataRepository(footballDataRepositoryImpl: FootballDataRepositoryImpl): FootballDataRepository {
        return footballDataRepositoryImpl
    }

    @Provides
    fun provideFootballDataAPI(retrofit: Retrofit): FootballDataAPI {
        return retrofit.create(FootballDataAPI::class.java)
    }

    @Provides
    fun provideFootballDataFromDatabase(footballDataFromDatabaseImpl: FootballDataFromDatabaseImpl): FootballDataFromDatabase {
        return footballDataFromDatabaseImpl
    }

    @Provides
    fun provideFootballDataFromNetwork(footballDataFromNetworkImpl: FootballDataFromNetworkImpl): FootballDataFromNetwork {
        return footballDataFromNetworkImpl
    }
}