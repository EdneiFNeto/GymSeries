package com.gymseries.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.IntensAdapter
import com.gymseries.model.Itens
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class MainFragments : Fragment() {

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


        var view = LayoutInflater.from(context).inflate(R.layout.layout_treino, container, false)
        var recyclerView = view.findViewById<RecyclerView>(R.id.recycle_view_main)
        var listItens = arrayOf(
            Itens(
                R.drawable.biceps,
                ResourcesUtils.getString(context, R.string.braco),
                ResourcesUtils.getString(context, R.string.biceps)
            ),
            Itens(
                R.drawable.triceps,
                ResourcesUtils.getString(context, R.string.braco),
                ResourcesUtils.getString(context, R.string.triceps)
            ),
            Itens(
                R.drawable.peito,
                ResourcesUtils.getString(context, R.string.serie_peito),
                ResourcesUtils.getString(context, R.string.peito)
            ),
            Itens(
                R.drawable.ombro,
                ResourcesUtils.getString(context, R.string.serie_ombro),
                ResourcesUtils.getString(context, R.string.ombro)
            ),
            Itens(
                R.drawable.costas,
                ResourcesUtils.getString(context, R.string.serie_costas),
                ResourcesUtils.getString(context, R.string.costas)
            ),
            Itens(
                R.drawable.pernas,
                ResourcesUtils.getString(context, R.string.serie_perna),
                ResourcesUtils.getString(context, R.string.perna)
            )
        )
        var adapter = IntensAdapter(context, listItens)
        recyclerView.adapter = adapter
        return view
    }
}
