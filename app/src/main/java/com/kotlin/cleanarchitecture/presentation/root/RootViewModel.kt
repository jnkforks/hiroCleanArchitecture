package com.kotlin.cleanarchitecture.presentation.root

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.cleanarchitecture.state.PokeState.pokeListLiveData
import com.kotlin.project.domain.di.qualifier.PokemonListUseCase
import com.kotlin.project.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RootViewModel @ViewModelInject constructor(
    @PokemonListUseCase private val useCase: GetPokemonListUseCase
) : ViewModel() {
    fun retryData() {
        val jsonNumber = 0
        viewModelScope.launch(Dispatchers.Default) {
            pokeListLiveData.postValue(useCase.getList("pokedex$jsonNumber.json"))
        }
    }
}
