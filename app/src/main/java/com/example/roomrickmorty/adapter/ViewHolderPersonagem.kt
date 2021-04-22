package com.example.roomrickmorty.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrickmorty.R

class ViewHolderPersonagem (view: View) : RecyclerView.ViewHolder(view) {

    val nomeDoPersonagem by lazy { view.findViewById<TextView>(R.id.nome_personagem) }
    val imagemDoPersonagem by lazy { view.findViewById<ImageView>(R.id.imagem_personagem) }
}