package com.example.football_exp.core.di

import android.app.Application
import android.arch.persistence.room.Room
import com.example.football_exp.data.database.LocalFootballDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private var mApplication: Application) {

    @Singleton
    @Provides
    fun providesRoomDatabase(): LocalFootballDB {
        return Room.databaseBuilder(mApplication, LocalFootballDB::class.java, "football-db").build()
    }
}