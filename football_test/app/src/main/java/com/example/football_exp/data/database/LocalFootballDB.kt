package com.example.football_exp.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.football_exp.data.database.dao.PlayerDAO
import com.example.football_exp.data.database.dao.TeamDAO
import com.example.football_exp.data.database.models.PlayerEntity
import com.example.football_exp.data.database.models.TeamEntity

@Database(entities = [TeamEntity::class , PlayerEntity::class], version = 1)

abstract class LocalFootballDB: RoomDatabase() {

   abstract fun getTeamDAO(): TeamDAO

   abstract fun getPlayerDAO(): PlayerDAO
}