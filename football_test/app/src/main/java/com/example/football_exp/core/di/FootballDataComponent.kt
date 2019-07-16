package com.example.football_exp.core.di

import com.example.football_exp.presentation.competition_list.CompetitionListFragment
import com.example.football_exp.presentation.player_list.PlayerListFragment
import com.example.football_exp.presentation.team_list.TeamListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, FootballDataModule::class, AppModule::class, RoomModule::class])

interface FootballDataComponent {

    fun inject(teamListFragment: TeamListFragment)

    fun inject(playerListFragment: PlayerListFragment)

    fun inject(competitionListFragment: CompetitionListFragment)

}