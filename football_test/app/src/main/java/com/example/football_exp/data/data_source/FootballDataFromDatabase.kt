package com.example.football_exp.data.data_source

import com.example.football_exp.data.database.models.PlayerEntity
import com.example.football_exp.data.network.models.TeamDto
import io.reactivex.Single

interface FootballDataFromDatabase {

    fun getTeamById(teamId: Int): Single<List<PlayerEntity>>

    fun saveTeam(team: TeamDto)
}