package com.example.roomrickmorty.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

class RetrofitInit (url: String) {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T : Any> create(clazz: KClass<T>): T = retrofit.create(clazz.java)

}