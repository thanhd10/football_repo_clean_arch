package com.example.football_exp.data.database

import com.example.football_exp.data.database.models.PlayerEntity
import com.example.football_exp.data.database.models.TeamEntity
import com.example.football_exp.data.network.models.PlayerDto
import com.example.football_exp.data.network.models.TeamDto

class RetrofitToRoomTransformer{

    companion object {

    fun convertTeam(teamDto: TeamDto): TeamEntity{
        return TeamEntity(teamDto.teamId, teamDto.name, teamDto.shortName, teamDto.tla, teamDto.crestUrl,
            teamDto.address, teamDto.phone, teamDto.website, teamDto.email, teamDto.founded,
            teamDto.clubColors,teamDto.venue, teamDto.lastUpdated)
    }

    fun convertPlayer(playerDto: PlayerDto, teamId: Int): PlayerEntity{
        return PlayerEntity(playerDto.playerId, playerDto.name, playerDto.firstName, playerDto.lastName,
            playerDto.dateOfBirth, playerDto.countryOfBirth, playerDto.nationality, playerDto.position, playerDto.lastUpdated,
            teamId)
    }
        }
}

