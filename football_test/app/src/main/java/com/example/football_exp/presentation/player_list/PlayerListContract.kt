package com.example.football_exp.presentation.player_list

import com.example.football_exp.BaseContract
import com.example.football_exp.presentation.models.Player

interface PlayerListContract {

    interface View: BaseContract.BaseView{
        fun showPlayers(players: List<Player>)

    }

    interface Presenter: BaseContract.BasePresenter{

        fun handlePlayersOfTeam(teamId: Int)

        fun setView(view: View)
    }
}