package com.example.football_exp.data.network.models

import com.google.gson.annotations.SerializedName

data class SeasonDto(@SerializedName("id") val seasonId: Int,
                     @SerializedName("startDate") val startDate: String?,
                     @SerializedName("endDate") val endDate: String?,
                     @SerializedName("currentMatchDay") val currentMatchDay: Int?,
                     @SerializedName("availableStages") val availableStages: List<String>?
                     )