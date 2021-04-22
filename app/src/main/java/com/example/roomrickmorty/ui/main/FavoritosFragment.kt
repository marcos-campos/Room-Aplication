package com.example.roomrickmorty.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomrickmorty.R
import com.example.roomrickmorty.adapter.AdapterFavoritos
import com.example.roomrickmorty.room.Favoritos
import com.example.roomrickmorty.room.FavoritosDatabase

class FavoritosFragment: Fragment() {

    companion object {
    }

    private val databaseFavoritos by lazy {
        activity?.let { Room.databaseBuilder(
            it,
            FavoritosDatabase::class.java,
            "databaseFavoritos"
        ).build()
        }
    }


    private val viewModelListaFavoritos by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    val recyclerFavoritos by lazy { view?.findViewById<RecyclerView>(R.id.recycler_main_favoritos) }
    var listPersonagensFavoritos = mutableListOf<Favoritos>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_favoritos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelListaFavoritos.database = this!!.databaseFavoritos!!
        recyclerFavoritos?.layoutManager = LinearLayoutManager(activity)

        viewModelListaFavoritos.buscarFavorito()

        viewModelListaFavoritos.personagemFavoritoLiveData.observe(this, Observer {
            listPersonagensFavoritos.addAll(it)

            val adapter = activity?.let { it1 -> AdapterFavoritos(listPersonagensFavoritos, it1) }
            recyclerFavoritos?.adapter = adapter
        })

    }

}