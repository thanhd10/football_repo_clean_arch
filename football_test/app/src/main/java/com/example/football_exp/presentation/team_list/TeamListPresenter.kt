package com.example.football_exp.presentation.team_list

import com.example.football_exp.data.data_source.FootballDataFromNetwork
import com.example.football_exp.presentation.transformer.TeamTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TeamListPresenter @Inject constructor(
    private var footballDataFromNetwork: FootballDataFromNetwork
): TeamListContract.Presenter {

    private var disposable: Disposable? = null
    private lateinit var view: TeamListContract.View

    override fun setView(view: TeamListContract.View) {
        this.view = view
    }

    override fun loadTeamsOfCompetition(competitionId: Int) {
        disposable = footballDataFromNetwork.getTeamsByCompetitionId(competitionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ teamsByCompetition ->
                view.showTeams(TeamTransformer.transformToTeams(teamsByCompetition.teamsDto))
            },
                {
                    view.showErrorMessage()
            })
    }

    override fun onUnbind() {
        disposable!!.dispose()
    }
}