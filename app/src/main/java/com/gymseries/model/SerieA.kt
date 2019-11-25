package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class SerieA (
    @PrimaryKey(autoGenerate = true)
    private val id:Long,
    val biceps: Biceps,
    val triceps: Triceps,
    val ombro: Ombro,
    val perna: Perna
){

}
