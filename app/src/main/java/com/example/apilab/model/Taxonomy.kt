package com.example.apilab.model

import com.google.gson.annotations.SerializedName
data class Taxonomy(
    @SerializedName("scientific_name")
    val scientificName: String
)
