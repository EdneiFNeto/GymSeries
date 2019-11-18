package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Triceps(

    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val status: Boolean,
    val peso: String,
    val descr: String,
    val repeticoes: String
) {}