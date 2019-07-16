package com.example.football_exp.data.network



import com.example.football_exp.data.network.models.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface FootballDataAPI {

    @GET("/v2/competitions/{id}/teams")
    fun teamsByCompetitionId(@Path("id") id:Int): Single<TeamsForCompetitionDto>

    @GET("/v2/teams/{id}")
    fun getTeamById(@Path("id") id: Int): Single<TeamDto>

    @GET("/v2/players/{id}")
    fun getPlayerById(@Path("id") id: Int): Single<PlayerDto>

    @GET("/v2/competitions/")
    fun getAllCompetitions(): Single<AllCompetitionsDto>

    @GET("/v2/competitions/2000")
    fun getSingleCompetition(): Single<CompetitionDto>
}