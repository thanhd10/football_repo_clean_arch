package com.example.football_exp.data.database.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "competition")
data class CompetitionEntity(@PrimaryKey @ColumnInfo(name = "competitionId") val competitionId: Int,
                             @Embedded @ColumnInfo(name = "area") val area: AreaEntity?,
                             @ColumnInfo(name = "competitionName") val competitionName: String?,
                             @ColumnInfo(name = "code") val code: String?,
                             @ColumnInfo(name = "plan") val plan: String?,
                             //val currentSeason: SeasonDto?,
                             @ColumnInfo(name = "numberOfAvailableSeasons") val numberOfAvailableSeasons: Int?,
                             @ColumnInfo(name = "lastUpdated") val lastUpdated: String?)