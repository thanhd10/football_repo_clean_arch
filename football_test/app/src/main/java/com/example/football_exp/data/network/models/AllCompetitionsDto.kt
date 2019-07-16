package com.example.football_exp.data.network.models

import com.google.gson.annotations.SerializedName

data class AllCompetitionsDto(@SerializedName("count") val count: Int,
                              @SerializedName("filters") val filters: Any?,
                              @SerializedName("competitions") val competitions: List<CompetitionDto>)