package com.example.football_exp.presentation.transformer

import com.example.football_exp.data.network.models.CompetitionDto
import com.example.football_exp.presentation.models.Competition

class CompetitionTransformer {

    companion object {

        private fun transformToCompetition(competitionDto: CompetitionDto): Competition{
            return Competition(
                competitionDto.competitionId,
                competitionDto.area?.name,
                competitionDto.competitionName,
                competitionDto.plan)
        }

        fun transformToCompetitions(competitionsDto: List<CompetitionDto>): List<Competition>{
            return competitionsDto.map { c ->
                transformToCompetition(c)
            }
        }
    }
}