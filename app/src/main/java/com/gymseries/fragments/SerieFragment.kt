package com.gymseries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.async.ListEntityForStatus
import com.gymseries.model.*

class SerieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = LayoutInflater.from(context)
            .inflate(R.layout.activity_serie, container, false)

        var serie_peito = view.findViewById<RecyclerView>(R.id.recycleview_series_peito)
        var serie_triceps = view.findViewById<RecyclerView>(R.id.recycleview_series_triceps)

        var serie_perna = view.findViewById<RecyclerView>(R.id.recycleview_series_perna_a)
        var serie_ombro = view.findViewById<RecyclerView>(R.id.recycleview_series_ombro_b)

        var serie_biceps = view.findViewById<RecyclerView>(R.id.recycleview_series_boceps)
        var serie_costas = view.findViewById<RecyclerView>(R.id.recycleview_series_costas)

        var serie_ombro_b = view.findViewById<RecyclerView>(R.id.recycleview_series_ombro_b)
        val ombros_b = arrayListOf<Ombro>()
        var ombros_B_Adapter = MyGenericAdapter(context, ombros_b, 3, false)
        serie_ombro_b.adapter = ombros_B_Adapter

        var serie_perna_a = view.findViewById<RecyclerView>(R.id.recycleview_series_perna_b)
        val pernas_a = arrayListOf<Perna>()
        var pernas_A_Adapter = MyGenericAdapter(context, pernas_a, 5, false)
        serie_perna_a.adapter = pernas_A_Adapter

        val triceps = arrayListOf<Triceps>()
        var tricepsAdapter = MyGenericAdapter(context, triceps, 1, false)
        serie_triceps.adapter = tricepsAdapter

        val peitos = arrayListOf<Peito>()
        var peitosAdapter = MyGenericAdapter(context, peitos, 2, false)
        serie_peito.adapter = peitosAdapter

        val ombros = arrayListOf<Ombro>()
        var ombrosAdapter = MyGenericAdapter(context, ombros, 3, false)
        serie_ombro.adapter = ombrosAdapter

        val pernas = arrayListOf<Perna>()
        var pernasAdapter = MyGenericAdapter(context, pernas, 5, false)
        serie_perna.adapter = pernasAdapter

        val biceps = arrayListOf<Biceps>()
        var bicepsAdapter = MyGenericAdapter(context, biceps, 0, false)
        serie_biceps.adapter = bicepsAdapter

        val costas = arrayListOf<Costa>()
        var costasdapter = MyGenericAdapter(context, costas, 4, false)
        serie_costas.adapter = costasdapter

        ListEntityForStatus(context, triceps, tricepsAdapter, 1, true).execute()
        ListEntityForStatus(context, peitos, peitosAdapter, 2, true).execute()

        ListEntityForStatus(context, ombros, ombrosAdapter, 3, true).execute()
        ListEntityForStatus(context, ombros, ombros_B_Adapter, 3, true).execute()
        ListEntityForStatus(context, pernas, pernasAdapter, 5, true).execute()
        ListEntityForStatus(context, pernas, pernas_A_Adapter, 5, true).execute()

        ListEntityForStatus(context, biceps, bicepsAdapter, 0, true).execute()
        ListEntityForStatus(context, costas, costasdapter, 4, true).execute()

        return view
    }
}
