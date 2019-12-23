package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val altura: String,
    val peso: String,
    val sexo: String
) {

    override fun toString(): String {
        return String.format("%s, %s, %s", altura, peso, sexo)
    }
}
