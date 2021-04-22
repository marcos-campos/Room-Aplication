package com.example.roomrickmorty.repository

import com.example.roomrickmorty.model.Character
import com.example.roomrickmorty.network.EndPoints
import com.example.roomrickmorty.network.RetrofitInit
import java.nio.charset.CharacterCodingException

class RepositoryApi {

    private var url = "https://rickandmortyapi.com/api/"

    private var service = EndPoints::class

    private val conectionService = RetrofitInit(url).create(service)

    suspend fun pegarPersonagemCoroutine(): Character = conectionService.pegarPersonagem()

}