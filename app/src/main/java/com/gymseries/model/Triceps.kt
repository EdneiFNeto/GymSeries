package com.gymseries.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Triceps(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val descr: String,
    val status: Boolean,
    val pepeticao: String,
    val peso: String
) {

    override fun toString(): String {
        return String.format("%s", descr)
    }
}
