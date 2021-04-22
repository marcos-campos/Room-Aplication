package com.example.roomrickmorty.ui.main

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.roomrickmorty.R
import com.example.roomrickmorty.model.Result
import com.example.roomrickmorty.room.Favoritos
import com.example.roomrickmorty.room.FavoritosDatabase
import com.squareup.picasso.Picasso

class MainCharacter: AppCompatActivity() {

    private val databaseFavoritos by lazy {
        Room.databaseBuilder(
                    applicationContext,
                    FavoritosDatabase::class.java,
                    "databaseFavoritos"
            ).build()
        }

    private val viewModelFav by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    val nameCharacter by lazy { findViewById<TextView>(R.id.detalhe_nome_personagem) }
    val specieCharacter by lazy { findViewById<TextView>(R.id.detalhe_especie_personagem) }
    val genderCharacter by lazy { findViewById<TextView>(R.id.detalhe_genero_personagem) }
    val imgCharacter by lazy { findViewById<ImageView>(R.id.detalhe_imagem_personagem) }

    val favorito1 by lazy {findViewById<ImageView>(R.id.fav1)}
    val favorito2 by lazy {findViewById<ImageView>(R.id.fav2)}

    lateinit var informacoes: Bundle
    lateinit var infCharacter: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_character)

        intent.extras?.let {
            informacoes = it
        }

        infCharacter = informacoes.getSerializable("dados") as Result

        viewModelFav.database = databaseFavoritos

            nameCharacter.text = infCharacter.name
            specieCharacter.text = infCharacter.species
            genderCharacter.text = infCharacter.gender
            Picasso.with(this).load(infCharacter.image).into(imgCharacter)

            setClickListeners()
            verificarFavoritos()

    }

    fun setClickListeners(){

        favorito1?.setOnClickListener {
            favorito2?.visibility = VISIBLE
            adicionarContatoAosFavoritos(infCharacter.name.toString(), infCharacter.image.toString(),
                    infCharacter.gender.toString(), infCharacter.species.toString())
        }

        favorito2?.setOnClickListener {
            favorito2?.visibility = GONE
        }
    }


    fun adicionarContatoAosFavoritos(nome: String, imagem: String, genero: String, especie: String) {

        val contatoFavorito = Favoritos(image = imagem,
                gender = genero,
                name = nome,
                specie = especie)
        viewModelFav.addFavorito(contatoFavorito)
    }

    fun verificarFavoritos(){

        viewModelFav.personagemFavoritoLiveData.observe(this, Observer {
            val listOfFavorites = it

            val verificar = listOfFavorites.firstOrNull {
                it.name == infCharacter.name
            }
            verificar?.let {
                favorito2.visibility = VISIBLE
            }
        })

        viewModelFav.buscarFavorito()

    }
}