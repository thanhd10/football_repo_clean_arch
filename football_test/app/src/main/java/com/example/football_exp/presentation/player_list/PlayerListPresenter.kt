package com.example.football_exp.presentation.player_list

import com.example.football_exp.data.football_repos.FootballDataRepository
import com.example.football_exp.presentation.transformer.PlayerTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PlayerListPresenter @Inject constructor(
    private var footballDataRepository: FootballDataRepository
): PlayerListContract.Presenter {

    private var disposable: Disposable? = null
    private lateinit var view: PlayerListContract.View

    override fun setView(view: PlayerListContract.View) {
        this.view = view
    }

    override fun handlePlayersOfTeam(teamId: Int) {
        disposable = footballDataRepository.getPlayerListData(teamId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    t-> view.showPlayers(t)
                },
                {
                    view.showErrorMessage()
                }
            )
    }

    override fun onUnbind() {
        disposable!!.dispose()
    }

}