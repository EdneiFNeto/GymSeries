package com.gymseries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.async.ListEntityForStatus
import com.gymseries.model.*
import com.gymseries.utils.ResourcesUtils

class SerieBFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = LayoutInflater.from(context)
            .inflate(R.layout.activity_fragment_serie, container, false)

        var serie_costas = myView.findViewById<RecyclerView>(R.id.recycle_view_fragemtn_1)
        var serie_triceps = myView.findViewById<RecyclerView>(R.id.recycle_view_fragemtn_2)
        var serie_perna = myView.findViewById<RecyclerView>(R.id.recycle_view_fragemtn_3)
        var serie_ombro = myView.findViewById<RecyclerView>(R.id.recycle_view_fragemtn_4)

        var treino1 = myView.findViewById<TextView>(R.id.text_treino_1)
        var treino2 = myView.findViewById<TextView>(R.id.text_treino_2)
        var treino3 = myView.findViewById<TextView>(R.id.text_treino_3)
        var treino4 = myView.findViewById<TextView>(R.id.text_treino_4)

        treino1.text= ResourcesUtils.getString(context, R.string.title_biceps)
        treino2.text= ResourcesUtils.getString(context, R.string.title_costas)
        treino3.text= ResourcesUtils.getString(context, R.string.title_ombro)
        treino4.text= ResourcesUtils.getString(context, R.string.title_perna)

        val biceps = arrayListOf<Biceps>()
        var bicepsAdapter = MyGenericAdapter(context, biceps, 1, false)
        serie_triceps.adapter = bicepsAdapter

        val costas = arrayListOf<Costa>()
        var costasAdapter = MyGenericAdapter(context, costas, 2, false)
        serie_costas.adapter = costasAdapter

        val ombros = arrayListOf<Ombro>()
        var ombrosAdapter = MyGenericAdapter(context, ombros, 3, false)
        serie_ombro.adapter = ombrosAdapter

        val pernas = arrayListOf<Perna>()
        var pernasAdapter = MyGenericAdapter(context, pernas, 5, false)
        serie_perna.adapter = pernasAdapter

        ListEntityForStatus(context, biceps, bicepsAdapter, 0, true).execute()
        ListEntityForStatus(context, costas, costasAdapter, 4, true).execute()
        ListEntityForStatus(context, ombros, ombrosAdapter, 3, true).execute()
        ListEntityForStatus(context, pernas, pernasAdapter, 5, true).execute()
        return myView
    }

}
