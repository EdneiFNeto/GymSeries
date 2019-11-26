package com.gymseries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.async.ListEntityForStatus
import com.gymseries.model.*
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class SerieFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var supportActionBar = (activity as AppCompatActivity).supportActionBar
        ActionBarUtils.hide(supportActionBar)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = LayoutInflater.from(context).inflate(R.layout.activity_serie, container, false)

        /**
         * Serie A
         */

        var serie_peito = view.findViewById<RecyclerView>(R.id.recycleview_series_peito)
        val peitos = arrayListOf<Peito>()
        var peitosAdapter = MyGenericAdapter(context, peitos, 2, false)
        serie_peito.adapter = peitosAdapter
        ListEntityForStatus(context, peitos, peitosAdapter, ResourcesUtils.getString(context, R.string.a),2, true).execute()


        var serie_triceps = view.findViewById<RecyclerView>(R.id.recycleview_series_triceps)
        val triceps = arrayListOf<Triceps>()
        var tricepsAdapter = MyGenericAdapter(context, triceps, 1, false)
        serie_triceps.adapter = tricepsAdapter
        ListEntityForStatus(context, triceps, tricepsAdapter, ResourcesUtils.getString(context, R.string.a), 1, true).execute()


        var serie_ombro_a = view.findViewById<RecyclerView>(R.id.recycleview_series_ombro_a)
        val ombros_a = arrayListOf<Ombro>()
        var ombrosAdapter_A = MyGenericAdapter(context, ombros_a, 3, false)
        serie_ombro_a.adapter = ombrosAdapter_A
        ListEntityForStatus(context, ombros_a, ombrosAdapter_A, ResourcesUtils.getString(context, R.string.a), 3, true).execute()


        var serie_perna_a = view.findViewById<RecyclerView>(R.id.recycleview_series_perna_a)
        val pernas_a = arrayListOf<Perna>()
        var pernasAdapter_A = MyGenericAdapter(context, pernas_a, 5, false)
        serie_perna_a.adapter = pernasAdapter_A
        ListEntityForStatus(context, pernas_a, pernasAdapter_A, ResourcesUtils.getString(context, R.string.serie_a),  5, true).execute()

        /**
         * Serie B
         */

        var serie_biceps = view.findViewById<RecyclerView>(R.id.recycleview_series_biceps)
        val biceps = arrayListOf<Biceps>()
        var bicepsAdapter = MyGenericAdapter(context, biceps, 0, false)
        serie_biceps.adapter = bicepsAdapter
        ListEntityForStatus(context, biceps, bicepsAdapter, ResourcesUtils.getString(context, R.string.b),0, true).execute()


        var serie_costas = view.findViewById<RecyclerView>(R.id.recycleview_series_costas)
        val costas = arrayListOf<Costa>()
        var costasAdapter = MyGenericAdapter(context, costas, 4, false)
        serie_costas.adapter = costasAdapter
        ListEntityForStatus(context, costas, costasAdapter, ResourcesUtils.getString(context, R.string.b),4, true).execute()


        var serie_ombro_b = view.findViewById<RecyclerView>(R.id.recycleview_series_ombro_a)
        val ombros_b = arrayListOf<Ombro>()
        var ombrosAdapter_B = MyGenericAdapter(context, ombros_b, 3, false)
        serie_ombro_b.adapter = ombrosAdapter_B
        ListEntityForStatus(context, ombros_b, ombrosAdapter_B, ResourcesUtils.getString(context, R.string.b), 3, true).execute()


        var serie_perna_b = view.findViewById<RecyclerView>(R.id.recycleview_series_perna_a)
        val pernas_b = arrayListOf<Perna>()
        var pernasAdapter_B = MyGenericAdapter(context, pernas_b, 5, false)
        serie_perna_b.adapter = pernasAdapter_B
        ListEntityForStatus(context, pernas_b, pernasAdapter_B, ResourcesUtils.getString(context, R.string.b),  5, true).execute()

        return view
    }
}
