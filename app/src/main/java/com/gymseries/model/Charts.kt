package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Charts (
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val peito:Int,
    val braco:Int,
    val cintura:Int,
    val quadril:Int,
    val coxa:Int,
    val panturrilha:Int
){

}
