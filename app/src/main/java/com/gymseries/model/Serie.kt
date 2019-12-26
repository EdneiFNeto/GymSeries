package com.gymseries.model

import androidx.room.Entity

@Entity
class Serie(
    id: Long?,
    descr: String?,
    repeticoes: String?,
    peso: String?,
    serie: String?,
    status: Boolean?
) : Treino(id, descr, repeticoes, peso, serie, status) {


}

