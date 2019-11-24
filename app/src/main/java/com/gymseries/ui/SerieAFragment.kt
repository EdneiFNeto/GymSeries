package com.gymseries.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.async.ListEntityForStatus
import com.gymseries.model.Ombro
import com.gymseries.model.Peito
import com.gymseries.model.Perna
import com.gymseries.model.Triceps
import com.gymseries.utils.ResourcesUtils

class SerieAFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = LayoutInflater.from(context)
            .inflate(R.layout.activity_fragment_serie, container, false)

        var serie_peito = myView.findViewById<RecyclerView>(R.id.recycle_view_fragemtn_1)
        var serie_triceps = myView.findViewById<RecyclerView>(R.id.recycle_view_fragemtn_2)
        var serie_perna = myView.findViewById<RecyclerView>(R.id.recycle_view_fragemtn_3)
        var serie_ombro = myView.findViewById<RecyclerView>(R.id.recycle_view_fragemtn_4)

        var treino1 = myView.findViewById<TextView>(R.id.text_treino_1)
        var treino2 = myView.findViewById<TextView>(R.id.text_treino_2)
        var treino3 = myView.findViewById<TextView>(R.id.text_treino_3)
        var treino4 = myView.findViewById<TextView>(R.id.text_treino_4)

        treino1.text=ResourcesUtils.getString(context, R.string.title_triceps)
        treino2.text=ResourcesUtils.getString(context, R.string.title_peito)
        treino3.text=ResourcesUtils.getString(context, R.string.title_ombro)
        treino4.text=ResourcesUtils.getString(context, R.string.title_perna)

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

        ListEntityForStatus(context, triceps, tricepsAdapter, 1, true).execute()
        ListEntityForStatus(context, peitos, peitosAdapter, 2, true).execute()
        ListEntityForStatus(context, ombros, ombrosAdapter, 3, true).execute()
        ListEntityForStatus(context, pernas, pernasAdapter, 5, true).execute()
        return myView
    }
}
