package com.gymseries.model

import androidx.room.Entity

@Entity
class Serie : Treino {
    constructor(id: Long?, descr: String?, repeticoes: String?, peso: String?, serie: String?, status: Boolean?):
            super(id, descr, repeticoes, peso, serie, status)
}

