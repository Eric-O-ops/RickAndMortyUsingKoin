package com.geektech.rickandmortyusingkoin.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.geektech.rickandmortyusingkoin.data.network.api.CharacterApi
import com.geektech.rickandmortyusingkoin.data.repository.pagingsources.CharacterPagingSources
import com.geektech.rickandmortyusingkoin.model.CharacterModel

class CharacterRepository(private val characterApi: CharacterApi) {

    fun fetchCharacter(): LiveData<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                CharacterPagingSources(characterApi)
            }, initialKey = 1
        ).liveData
    }
}