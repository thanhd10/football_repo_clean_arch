package com.example.football_exp.data.database.models

import android.arch.persistence.room.*

@Entity(tableName = "team")
data class TeamEntity(@PrimaryKey @ColumnInfo(name="teamId") val teamId: Int,
                      //@ColumnInfo(name="area") val areaDto: AreaDto,
                      @ColumnInfo(name="name") val name: String,
                      @ColumnInfo(name="shortName") val shortName: String,
                      @ColumnInfo(name="tla") val tla: String,
                      @ColumnInfo(name="crestUrl") val crestUrl: String?,
                      @ColumnInfo(name="address") val address: String?,
                      @ColumnInfo(name="phone") val phone: String?,
                      @ColumnInfo(name="website") val website: String?,
                      @ColumnInfo(name="email") val email: String?,
                      @ColumnInfo(name="founded") val founded: Int?,
                      @ColumnInfo(name="clubColors") val clubColors: String?,
                      @ColumnInfo(name="venue") val venue: String?,
                      @ColumnInfo(name="lastUpdated") val lastUpdated: String?
                      //var squad: List<PlayerEntity>?
)
