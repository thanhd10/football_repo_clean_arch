package com.example.football_exp.data.network.models

import com.google.gson.annotations.SerializedName

data class PlayerDto (@SerializedName("id") val playerId: Int,
                      @SerializedName("name") val name: String,
                      @SerializedName("firstName") val firstName: String,
                      @SerializedName("lastName") val lastName: String,
                      @SerializedName("dateOfBirth") val dateOfBirth: String,
                      @SerializedName("countryOfBirth") val countryOfBirth: String,
                      @SerializedName("nationality") val nationality: String,
                      @SerializedName("position") val position: String,
                      @SerializedName("lastUpdated") val lastUpdated: String)
