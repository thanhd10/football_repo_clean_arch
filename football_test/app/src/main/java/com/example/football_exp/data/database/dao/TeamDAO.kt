package com.example.football_exp.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.football_exp.data.database.models.TeamEntity

@Dao
interface TeamDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(team: TeamEntity)

    @Query("SELECT * FROM team WHERE teamId=:teamId")
    fun getTeam(teamId: Int): TeamEntity
}