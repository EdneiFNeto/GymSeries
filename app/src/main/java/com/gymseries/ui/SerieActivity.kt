package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.*
import com.gymseries.async.ListarPernaSelecionados
import com.gymseries.async.ListarTricepsSelecionados
import com.gymseries.model.Peito
import com.gymseries.model.Perna
import com.gymseries.model.Triceps

class SerieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie)

        var serie_peito = findViewById<RecyclerView>(R.id.recycleview_series_peito)
        var serie_triceps = findViewById<RecyclerView>(R.id.recycleview_series_triceps)
        var serie_ombro = findViewById<RecyclerView>(R.id.recycleview_series_ombro)
        var serie_perna = findViewById<RecyclerView>(R.id.recycleview_series_perna)

        val peitos = arrayListOf<Peito>()
        var peitoAdapter = PeitoAdapter(this, peitos, false)
        serie_peito.adapter = peitoAdapter

        val triceps = arrayListOf<Triceps>()
        var adapterTriceps = TricepsAdapter(this, triceps, false)
        serie_triceps.adapter = adapterTriceps

//        val ombros = arrayListOf<Ombro>()
//        var adapterOmbros = OmbroSelecionadoAdapter(this, ombros)
//        serie_ombro.adapter = adapterOmbros
//
        val pernas = arrayListOf<Perna>()
        var adapterPerna= PernaAdapter(this, pernas, false)
        serie_perna.adapter = adapterPerna

        ListarTricepsSelecionados(this, adapterTriceps, triceps).execute()
        ListarPeitoSelecionados(this, peitoAdapter, peitos).execute()
        ListarPernaSelecionados(this, adapterPerna, pernas).execute()
//
//        ListarOmbroSelecionados(this, adapterTriceps, triceps).execute()
    }
}
