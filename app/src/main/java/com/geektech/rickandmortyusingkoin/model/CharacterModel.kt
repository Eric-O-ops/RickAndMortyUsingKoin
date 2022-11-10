package com.geektech.rickandmortyusingkoin.model

import com.google.gson.annotations.SerializedName

data class CharacterModel (

    @SerializedName("id")
    val id:Int,

    @SerializedName("name")
    val name: String
    )