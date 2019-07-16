package com.example.football_exp.core.di

import android.app.Application

object Injector {

    lateinit var footballDataComponent: FootballDataComponent

    fun init(application: Application){
        footballDataComponent = DaggerFootballDataComponent.builder()
            .networkModule(NetworkModule())
            .footballDataModule(FootballDataModule())
            .appModule(AppModule(application))
            .roomModule(RoomModule(application))
            .build()
    }
}