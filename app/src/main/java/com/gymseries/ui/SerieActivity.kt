package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.*
import com.gymseries.generics.async.ListEntityForStatus
import com.gymseries.model.Ombro
import com.gymseries.model.Peito
import com.gymseries.model.Perna
import com.gymseries.model.Triceps

class SerieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie)

        var serie_peito = findViewById<RecyclerView>(R.id.recycleview_series_peito)
        var serie_triceps = findViewById<RecyclerView>(R.id.recycleview_series_triceps)
        var serie_perna = findViewById<RecyclerView>(R.id.recycleview_series_perna)
        var serie_ombro = findViewById<RecyclerView>(R.id.recycleview_series_ombro)

        val triceps = arrayListOf<Triceps>()
        var tricepsAdapter = MyGenericAdapter(this, triceps, 1, false)
        serie_triceps.adapter = tricepsAdapter

        val peitos = arrayListOf<Peito>()
        var peitosAdapter = MyGenericAdapter(this, peitos, 2, false)
        serie_peito.adapter = peitosAdapter

        val ombros = arrayListOf<Ombro>()
        var ombrosAdapter = MyGenericAdapter(this, ombros, 3, false)
        serie_ombro.adapter = ombrosAdapter

        val pernas = arrayListOf<Perna>()
        var pernasAdapter = MyGenericAdapter(this, pernas, 5, false)
        serie_perna.adapter = pernasAdapter

        ListEntityForStatus(this, triceps, tricepsAdapter, 1, true).execute()
        ListEntityForStatus(this, peitos, peitosAdapter, 2, true).execute()
        ListEntityForStatus(this, ombros, ombrosAdapter, 3, true).execute()
        ListEntityForStatus(this, pernas, pernasAdapter, 5, true).execute()
    }
}
