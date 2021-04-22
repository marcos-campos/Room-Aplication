package com.example.roomrickmorty.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrickmorty.R
import com.example.roomrickmorty.room.Favoritos
import com.example.roomrickmorty.ui.main.FavoritosFragment
import com.squareup.picasso.Picasso

class AdapterFavoritos(
    private val listaPersonagensFavoritos: MutableList<Favoritos>,
    private val context: Context
) : RecyclerView.Adapter<ViewHolderFavoritos>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFavoritos {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_activity_favoritos, parent, false)
        return ViewHolderFavoritos(view)
    }

    override fun getItemCount(): Int = listaPersonagensFavoritos.size

    override fun onBindViewHolder(holder: ViewHolderFavoritos, position: Int) {
        val namePersonFavorite = holder.personagemFavoritoNome
        namePersonFavorite.text = listaPersonagensFavoritos[position].name

        val imagePersonFavorite = listaPersonagensFavoritos.elementAt(position)
        Picasso.with(context).load(imagePersonFavorite.image).into(holder.personagemFavoritoImagem)
    }
}
