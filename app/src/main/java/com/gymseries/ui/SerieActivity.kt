package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.AdapterGeneric
import com.gymseries.adapter.TricepsSelecionadoAdapter
import com.gymseries.async.ListarTricepsSelecionados
import com.gymseries.model.Peito
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
        var peitoAdapter = AdapterGeneric<Peito>(this, peitos)
        serie_peito.adapter=peitoAdapter

        val triceps = arrayListOf<Triceps>()
        var adapter = TricepsSelecionadoAdapter(this, triceps)
        serie_triceps.adapter = adapter


        ListarTricepsSelecionados(this, adapter, triceps).execute()
        ListarTricepsSelecionados(this, adapter, triceps).execute()
        ListarTricepsSelecionados(this, adapter, triceps).execute()
        ListarTricepsSelecionados(this, adapter, triceps).execute()
    }
}
