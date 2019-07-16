package com.example.football_exp.presentation.competition_list

import com.example.football_exp.BaseContract
import com.example.football_exp.presentation.models.Competition

interface CompetitionListContract {

    interface View: BaseContract.BaseView{

        fun showCompetitions(competitions: List<Competition>)

        fun onCompetitionItemClicked(competition: Competition)
    }

    interface Presenter: BaseContract.BasePresenter{

        fun loadCompetitions()

        fun setView(view: View)
    }
}