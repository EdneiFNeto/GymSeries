package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.GenericAdapter
import com.gymseries.adapter.OmbroAdapter
import com.gymseries.generics.ListOmbroAsync
import com.gymseries.model.Ombro

class OmbroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ombro)
        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_ombro)
        val ombros = ArrayList<Ombro>()
        var adapter = OmbroAdapter(this, ombros)
        recyclerViewTriceps.adapter = adapter

        val ombro = Ombro(id = 0, descr = null, peso = null, repeticao = null,status = false )
        ListOmbroAsync(this, ombros, ombro, adapter).execute()
    }
}
