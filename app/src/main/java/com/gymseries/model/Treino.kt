package com.gymseries.model

import androidx.room.PrimaryKey

open class Treino(
    @PrimaryKey(autoGenerate = true)
    open val id: Long?,
    open val descr: String?,
    open val repeticoes: String?,
    open val peso: String?,
    open val serie: String?,
    open val status: Boolean?
) {

    override fun toString(): String {
        return String.format("%s,%s,%s,%s,%s,%s", id, descr, repeticoes, peso, serie, status)
    }
}