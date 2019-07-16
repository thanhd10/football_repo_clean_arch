package com.example.football_exp.data.football_repos

import com.example.football_exp.data.database.models.PlayerEntity
import com.example.football_exp.data.network.models.TeamDto
import com.example.football_exp.presentation.models.Player
import io.reactivex.Single

interface FootballDataRepository {

    fun getPlayerListData(teamId: Int): Single<List<Player>>
}