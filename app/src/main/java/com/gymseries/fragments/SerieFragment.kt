package com.gymseries.fragments

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.adapter.SeriesAdapter
import com.gymseries.async.ListSeriesAsync
import com.gymseries.generics.async.ListEntityForStatus
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.*
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class SerieFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var supportActionBar = (activity as AppCompatActivity).supportActionBar
        ActionBarUtils.title(supportActionBar, ResourcesUtils.getString(context, R.string.title_treino))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = LayoutInflater.from(context).inflate(R.layout.activity_serie, container, false)
        var recycleviewSeries = view.findViewById<RecyclerView>(R.id.recycleview_series)
        val series = arrayListOf<Serie>()

        //select entity in data base
        var adapter = SeriesAdapter(context, series)
        recycleviewSeries.adapter = adapter
        ListEntityGenericAsync(context, series, adapter, ResourcesUtils.getString(context, R.string.op_serie)).execute()

        return view
    }
}
