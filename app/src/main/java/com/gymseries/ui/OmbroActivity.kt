package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.OmbroAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Ombro

class OmbroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ombro)
        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_ombro)
        val ombros = ArrayList<Ombro>()
        var adapter = OmbroAdapter(this, ombros)
        recyclerViewTriceps.adapter = adapter

        ListEntityGenericAsync<Ombro>(this, ombros, adapter, 3).execute()
    }
}
