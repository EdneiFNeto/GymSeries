package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class IMC(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val peso: Double,
    val altura: Double,
    val sexo: String?,
    val data: String,
    val resultado: String,
    val imc: String
) {

}
