package com.example.football_exp.data.data_source

import com.example.football_exp.data.network.FootballDataAPI
import com.example.football_exp.data.network.models.AllCompetitionsDto
import com.example.football_exp.data.network.models.CompetitionDto
import com.example.football_exp.data.network.models.TeamDto
import com.example.football_exp.data.network.models.TeamsForCompetitionDto
import io.reactivex.Single
import javax.inject.Inject

class FootballDataFromNetworkImpl @Inject constructor(
    private var footballDataAPI: FootballDataAPI
):
    FootballDataFromNetwork {

    override fun getTeamsByCompetitionId(competitionId: Int): Single<TeamsForCompetitionDto> {
        return footballDataAPI.teamsByCompetitionId(competitionId)
    }

    override fun getAllCompetitions(): Single<AllCompetitionsDto> {
       return footballDataAPI.getAllCompetitions()
    }

    override fun getSingleCompetition(): Single<CompetitionDto> {
        return footballDataAPI.getSingleCompetition()
    }

    override fun getTeamById(teamId: Int): Single<TeamDto> {
        return footballDataAPI.getTeamById(teamId)
    }
}