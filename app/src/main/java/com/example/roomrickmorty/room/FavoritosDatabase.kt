package com.example.roomrickmorty.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Favoritos::class], version = 1)
abstract class FavoritosDatabase: RoomDatabase() {
    abstract fun favoritosDao(): FavoritosDao
}