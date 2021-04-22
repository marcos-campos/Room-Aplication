package com.example.roomrickmorty.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favoritos (
        @PrimaryKey(autoGenerate = true) val id: Int? = null,
        @ColumnInfo val image: String,
        @ColumnInfo val gender: String,
        @ColumnInfo val name: String,
        @ColumnInfo val specie: String
)