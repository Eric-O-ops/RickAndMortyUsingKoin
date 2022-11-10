package com.geektech.rickandmortyusingkoin.data.network.api

import com.geektech.rickandmortyusingkoin.model.CharacterModel
import com.geektech.rickandmortyusingkoin.model.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/character")
    suspend fun fetchCharacter (
        @Query("page") page: Int
    ): RickAndMortyResponse<CharacterModel>
}