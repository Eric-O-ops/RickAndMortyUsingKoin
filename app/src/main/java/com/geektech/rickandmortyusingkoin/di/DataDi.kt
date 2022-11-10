package com.geektech.rickandmortyusingkoin.di

import com.geektech.rickandmortyusingkoin.data.repository.CharacterRepository
import com.geektech.rickandmortyusingkoin.ui.fragment.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule =  module {

    factory {
        CharacterRepository(get())

    }

    viewModel {
        CharacterViewModel(get())
    }
}