package com.geektech.rickandmortyusingkoin.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geektech.rickandmortyusingkoin.data.repository.CharacterRepository
import com.geektech.rickandmortyusingkoin.model.CharacterModel

class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    fun fetchCharacters(): LiveData<PagingData<CharacterModel>> {
        return repository.fetchCharacter().cachedIn(viewModelScope)
    }
}