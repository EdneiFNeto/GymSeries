package com.gymseries.model

import androidx.room.Entity

@Entity
class Ombro:Treino{
    constructor(id:Long, descr: String, repeticoes: String, peso: String, status: Boolean):
            super(id, descr, repeticoes, peso, status)
}


