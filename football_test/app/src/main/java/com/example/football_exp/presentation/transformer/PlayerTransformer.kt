package com.example.football_exp.presentation.transformer

import com.example.football_exp.data.database.models.PlayerEntity
import com.example.football_exp.data.network.models.PlayerDto
import com.example.football_exp.presentation.models.Player

class PlayerTransformer {

    companion object {

        fun transformToPlayer(playerEntity: PlayerEntity): Player {
            return Player(
                playerEntity.name,
                playerEntity.nationality,
                playerEntity.position
            )
        }

        fun transformEntityToPlayers(playersEntity: List<PlayerEntity>): List<Player> {
            return playersEntity.map { p ->
                transformToPlayer(p)
            }
        }

        fun transformToPlayer(playerDto: PlayerDto): Player {
            return Player(
                playerDto.name,
                playerDto.nationality,
                playerDto.position
            )
        }

        fun transformNetworkToPlayers(playersDto: List<PlayerDto>): List<Player> {
            return playersDto.map { p ->
                transformToPlayer(p)
            }
        }

    }
}