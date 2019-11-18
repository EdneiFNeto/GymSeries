package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Perna(

    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var descr: String,
    var peso: String,
    var repeticao: String,
    var status: Boolean
) {}
