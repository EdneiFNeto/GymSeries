package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Serie(

    @PrimaryKey(autoGenerate = true)
    var id:Long
    ) {}
