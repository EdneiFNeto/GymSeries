package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Charts (
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val peito:String,
    val braco:String,
    val cintura:String,
    val quadril:String,
    val coxa:String,
    val panturrilha:String,
    val data:String
){

    override fun toString(): String {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s",
            id, peito, braco, cintura, quadril, coxa, panturrilha, data)
    }
}
