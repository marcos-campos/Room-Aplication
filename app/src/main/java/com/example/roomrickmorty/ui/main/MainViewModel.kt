package com.example.roomrickmorty.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomrickmorty.model.Character
import com.example.roomrickmorty.model.Result
import com.example.roomrickmorty.repository.RepositoryApi
import com.example.roomrickmorty.room.Favoritos
import com.example.roomrickmorty.room.FavoritosDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    lateinit var database: FavoritosDatabase
    val personagemFavoritoLiveData by lazy {MutableLiveData<List<Favoritos>>()}
    val repository = RepositoryApi()
    val personagemLiveData = MutableLiveData<List<Result>>()

    fun pegarPersonagemCoroutineOk() {
        CoroutineScope(Dispatchers.IO).launch {
            repository.pegarPersonagemCoroutine().let {character ->
                character.results?.let {
                    personagemLiveData.postValue(it)
                }
            }
        }
    }

    fun buscarFavorito() {
        viewModelScope.launch {
            val personagemFavorito = database.favoritosDao().getAll()
            personagemFavoritoLiveData.postValue(personagemFavorito)
        }
    }

    fun addFavorito(personagemFavorito: Favoritos) {
        viewModelScope.launch {
            database.favoritosDao().insertAll(personagemFavorito)
        }.invokeOnCompletion {
            buscarFavorito()
        }
    }

}