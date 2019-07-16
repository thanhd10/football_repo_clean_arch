package com.example.football_exp.presentation.team_list

import com.example.football_exp.BaseContract
import com.example.football_exp.presentation.models.Team

class TeamListContract {

    interface View: BaseContract.BaseView{

        fun showTeams(teams: List<Team>)

        fun onTeamItemClicked(team: Team)
    }

    interface Presenter: BaseContract.BasePresenter{

        fun loadTeamsOfCompetition(competitionId: Int)

        fun setView(view: View)
    }
}