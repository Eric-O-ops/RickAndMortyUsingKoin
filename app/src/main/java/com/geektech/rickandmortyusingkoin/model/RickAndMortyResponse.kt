package com.geektech.rickandmortyusingkoin.model

import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse<T> (

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: ArrayList<T>
)
