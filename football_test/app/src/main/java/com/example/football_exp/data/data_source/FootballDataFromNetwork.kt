package com.example.football_exp.data.data_source

import com.example.football_exp.data.network.models.AllCompetitionsDto
import com.example.football_exp.data.network.models.CompetitionDto
import com.example.football_exp.data.network.models.TeamDto
import com.example.football_exp.data.network.models.TeamsForCompetitionDto
import io.reactivex.Single


interface FootballDataFromNetwork {

    fun getTeamById(teamId: Int): Single<TeamDto>

    fun getTeamsByCompetitionId(competitionId: Int): Single<TeamsForCompetitionDto>

    fun getAllCompetitions(): Single<AllCompetitionsDto>

    fun getSingleCompetition(): Single<CompetitionDto>

}