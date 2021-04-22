package com.example.roomrickmorty.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrickmorty.R

class ViewHolderFavoritos (view: View) : RecyclerView.ViewHolder(view) {

    val personagemFavoritoNome by lazy { view.findViewById<TextView>(R.id.favoritos_nome_personagem) }
    val personagemFavoritoImagem by lazy { view.findViewById<ImageView>(R.id.favoritos_imagem_personagem) }
}