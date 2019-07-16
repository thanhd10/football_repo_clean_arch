package com.example.football_exp.data.network.models

import com.google.gson.annotations.SerializedName

data class CompetitionDto(@SerializedName("id") val competitionId: Int,
                          @SerializedName("area") val area: AreaDto?,
                          @SerializedName("name") val competitionName: String?,
                          @SerializedName("code") val code: String?,
                          @SerializedName("plan") val plan: String?,
                          @SerializedName("currentSeason") val currentSeason: SeasonDto?,
                          @SerializedName("numberOfAvailableSeasons") val numberOfAvailableSeasons: Int?,
                          @SerializedName("lastUpdated") val lastUpdated: String?)