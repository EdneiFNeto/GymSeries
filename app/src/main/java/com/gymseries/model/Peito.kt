package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Peito(
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    var descr:String,
    var peso:String,
    var repeticao:String
){}
