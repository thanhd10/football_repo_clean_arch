package com.example.football_exp.data.network.models

import com.google.gson.annotations.SerializedName

data class TeamsForCompetitionDto(@SerializedName("count") val count: Int,
                                  @SerializedName("filters") val filters: Any?,
                                  @SerializedName("competition") val competitionDto: CompetitionDto?,
                                  @SerializedName("season") val seasonDto: SeasonDto?,
                                  @SerializedName("teams") val teamsDto: List<TeamDto>)