package com.example.football_exp.data.football_repos

import com.example.football_exp.data.data_source.FootballDataFromDatabase
import com.example.football_exp.data.data_source.FootballDataFromNetwork
import com.example.football_exp.presentation.models.Player
import com.example.football_exp.presentation.transformer.PlayerTransformer
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import javax.inject.Inject


class FootballDataRepositoryImpl @Inject constructor(private val fromDatabase: FootballDataFromDatabase,
                                                     private val fromNetwork: FootballDataFromNetwork
):
    FootballDataRepository {

    private var disposable: Disposable? = null

    override fun getPlayerListData(teamId: Int): Single<List<Player>> {

        var isDataBaseEmpty = true

        val teamDataFromDataBase = fromDatabase.getTeamById(teamId).
            toObservable()
            .doOnNext { isDataBaseEmpty = false }
           // .doOnComplete { isDataBaseEmpty = false }
            .flatMap {l ->
                Observable.fromIterable(l)
                    .map { player-> PlayerTransformer.transformToPlayer(player) }
                    .toList()
                    .toObservable()
            }

        val teamDataFromNetwork = fromNetwork.getTeamById(teamId)
            .toObservable()
            .doOnNext {team -> fromDatabase.saveTeam(team) }
            .flatMap { team ->
                Observable.fromIterable(team.squad)
                    .map { player -> PlayerTransformer.transformToPlayer(player) }
                    .toList()
                    .toObservable()
            }

        disposable = Observable.concat(teamDataFromDataBase, teamDataFromNetwork)
            .firstElement()
            .subscribe {}

        return if (isDataBaseEmpty)
            teamDataFromNetwork.singleOrError()
        else
            teamDataFromDataBase.singleOrError()

/*
        return teamDataFromDataBase.flatMap { l ->
            Observable.fromIterable(l)
                .map { item -> PlayerTransformer.transformToPlayer(item) }
                .toList()
                .toObservable()
        }.singleOrError()
*/
  /*      return teamDataFromNetwork.flatMap { team ->
            Observable.fromIterable(team.squad)
                .map { item -> PlayerTransformer.transformToPlayer(item) }
                .toList()
                .toObservable()
        }.singleOrError()
        */
    }

}