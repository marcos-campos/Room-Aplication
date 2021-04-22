package com.example.roomrickmorty.network

import com.example.roomrickmorty.model.Character
import retrofit2.http.GET

interface EndPoints {

    @GET("character")
    suspend fun pegarPersonagem(): Character
}