package com.example.football_exp.data.network.models

import com.google.gson.annotations.SerializedName

data class AreaDto (@SerializedName("id") val areaId: Int,
                    @SerializedName("name") val name: String)
