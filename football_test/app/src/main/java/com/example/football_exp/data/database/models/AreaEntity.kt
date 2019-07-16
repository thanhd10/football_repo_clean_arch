package com.example.football_exp.data.database.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = "area")
data class AreaEntity(@ColumnInfo(name = "areaId") val areaId: Int,
                      @ColumnInfo(name = "name") val name: String)