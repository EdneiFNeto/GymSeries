package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val altura: Double,
    val peso: Double,
    val sexo: String,
    val resultado:String,
    val  data:String,
    val imc: String?
) {

    override fun toString(): String {
        return String.format("%s, %s, %s", altura, peso, sexo)
    }
}
