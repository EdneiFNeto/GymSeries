package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Triceps

class Tricesctivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tricesctivity)

        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_triceps)
        val triceps = ArrayList<Triceps>()
        var adapter = TricepsAdapter(this, triceps, true)
        recyclerViewTriceps.adapter = adapter

        ListEntityGenericAsync(this, triceps, adapter, 1).execute()
    }
}

