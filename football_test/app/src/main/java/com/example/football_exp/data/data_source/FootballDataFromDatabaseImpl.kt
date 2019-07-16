package com.example.football_exp.data.data_source

import com.example.football_exp.data.database.LocalFootballDB
import com.example.football_exp.data.database.RetrofitToRoomTransformer
import com.example.football_exp.data.database.models.PlayerEntity
import com.example.football_exp.data.network.models.TeamDto
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FootballDataFromDatabaseImpl @Inject constructor(
    private var localFootballDB: LocalFootballDB):

    FootballDataFromDatabase {

    override fun saveTeam(team: TeamDto) {
        localFootballDB.getTeamDAO().insertTeam(RetrofitToRoomTransformer.convertTeam(team))
        team.squad.map { playerDto -> ( localFootballDB.getPlayerDAO().insertPlayer(
            RetrofitToRoomTransformer.convertPlayer(playerDto,team.teamId))) }
    }

    override fun getTeamById(teamId: Int): Single<List<PlayerEntity>> {
        return localFootballDB.getPlayerDAO().getPlayersForTeam(teamId)
            .subscribeOn(Schedulers.io())
    }
}