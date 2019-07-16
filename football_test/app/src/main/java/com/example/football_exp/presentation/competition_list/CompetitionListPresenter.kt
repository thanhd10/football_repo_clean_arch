package com.example.football_exp.presentation.competition_list

import com.example.football_exp.data.data_source.FootballDataFromNetwork
import com.example.football_exp.presentation.transformer.CompetitionTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CompetitionListPresenter @Inject constructor(
    private var footballDataFromNetwork: FootballDataFromNetwork
) : CompetitionListContract.Presenter{

    private var disposable: Disposable? = null
    private lateinit var view: CompetitionListContract.View

    override fun setView(view: CompetitionListContract.View) {
        this.view = view
    }

    override fun loadCompetitions() {
        disposable = footballDataFromNetwork.getAllCompetitions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( { allCompetitionsDto ->
                view.showCompetitions(CompetitionTransformer.transformToCompetitions((allCompetitionsDto.competitions)))
            },
                {
                    view.showErrorMessage()
                })
    }

    override fun onUnbind() {
        disposable!!.dispose()
    }
}