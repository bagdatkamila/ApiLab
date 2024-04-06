package com.example.apilab.model

import com.google.gson.annotations.SerializedName
data class Characteristics(
    @SerializedName("most_distinctive_feature")
    val mostDistinctiveFeature: String,

    @SerializedName("skin_type")
    val skinType: String,

    @SerializedName("lifespan")
    val lifespan: String,

)
