package com.example.football_exp.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.football_exp.data.database.models.PlayerEntity
import io.reactivex.Single

@Dao
interface PlayerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayer(playerEntity: PlayerEntity)

    @Query("SELECT * FROM player WHERE teamId=:teamId")
    fun getPlayersForTeam(teamId: Int): Single<List<PlayerEntity>>
}