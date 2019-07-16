package com.example.football_exp.data.database.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [(ForeignKey(entity = TeamEntity::class, parentColumns = ["teamId"], childColumns = ["teamId"])) ],
    tableName = "player")
data class PlayerEntity (@PrimaryKey @ColumnInfo(name="id") val playerId: Int,
                         @ColumnInfo(name="name") val name: String,
                         @ColumnInfo(name="firstName") val firstName: String?,
                         @ColumnInfo(name="lastName") val lastName: String?,
                         @ColumnInfo(name="dateOfBirth") val dateOfBirth: String?,
                         @ColumnInfo(name="countryOfBirth") val countryOfBirth: String?,
                         @ColumnInfo(name="nationality") val nationality: String?,
                         @ColumnInfo(name="position") val position: String?,
                         @ColumnInfo(name="lastUpdated") val lastUpdated: String?,
                         @ColumnInfo(name="teamId") val teamId: Int?)
