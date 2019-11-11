package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Biceps(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val descr: String,
    val status: Boolean,
    val pepeticao: String,
    val peso: String
) {}
