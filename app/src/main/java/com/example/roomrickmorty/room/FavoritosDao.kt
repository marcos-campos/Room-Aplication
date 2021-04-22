package com.example.roomrickmorty.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoritosDao {
    @Query("SELECT * FROM favoritos")
    suspend fun getAll(): List<Favoritos>

    @Insert
    suspend fun insertAll(vararg favorito: Favoritos)

    @Delete
    suspend fun delete (favorito: Favoritos)
}