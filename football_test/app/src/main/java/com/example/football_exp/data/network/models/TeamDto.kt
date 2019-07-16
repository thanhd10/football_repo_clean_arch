package com.example.football_exp.data.network.models

import com.google.gson.annotations.SerializedName

data class TeamDto(@SerializedName("id") val teamId: Int,
                   @SerializedName("area") val areaDto: AreaDto,
                   @SerializedName("name") val name: String,
                   @SerializedName("shortName") val shortName: String,
                   @SerializedName("tla") val tla: String,
                   @SerializedName("crestUrl") val crestUrl: String,
                   @SerializedName("address") val address: String,
                   @SerializedName("phone") val phone: String,
                   @SerializedName("website") val website: String,
                   @SerializedName("email") val email: String,
                   @SerializedName("founded") val founded: Int,
                   @SerializedName("clubColors") val clubColors: String,
                   @SerializedName("venue") val venue: String,
                   @SerializedName("squad") val squad: List<PlayerDto>,
                   @SerializedName("lastUpdated") val lastUpdated: String)
