package com.example.roomrickmorty.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomrickmorty.R
import com.example.roomrickmorty.model.Result
import com.example.roomrickmorty.ui.main.MainCharacter
import com.squareup.picasso.Picasso

class AdapterPersonagem(
    private val listaPersonagens: MutableList<Result>,
    private val context: Context
    ) : RecyclerView.Adapter<ViewHolderPersonagem>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPersonagem {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_activity_character, parent, false)
        return ViewHolderPersonagem(view)
    }

    override fun getItemCount() = listaPersonagens.size

    override fun onBindViewHolder(holder: ViewHolderPersonagem, position: Int) {
        val nameOfPersonagem = holder.nomeDoPersonagem
        nameOfPersonagem.text = listaPersonagens[position].name

        val imageOfPersonagem = listaPersonagens.elementAt(position)
        Picasso.with(context).load(imageOfPersonagem.image).into(holder.imagemDoPersonagem)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, MainCharacter::class.java)

            intent.putExtra("dados", listaPersonagens[position])

            it.context.startActivity(intent)
        }
    }
}

