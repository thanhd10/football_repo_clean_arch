package com.example.football_exp.presentation.transformer

import com.example.football_exp.data.network.models.TeamDto
import com.example.football_exp.presentation.models.Team

class TeamTransformer {

    companion object {

        private fun transformToTeam(teamDto: TeamDto): Team{
            return Team(
                teamDto.teamId,
                teamDto.name,
                teamDto.website,
                teamDto.clubColors
            )
        }

        fun transformToTeams(teamsDto: List<TeamDto>): List<Team>{
            return teamsDto.map { t ->
                transformToTeam(t)
            }
        }
    }
}