package com.example.roomrickmorty.model

import java.io.Serializable

data class Character(
    val info: Info?,
    val results: List<Result>?
) : Serializable