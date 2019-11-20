package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.BycipesAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Biceps

class BicepsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biceps_triceps)

        var recyclerViewBiceps = findViewById<RecyclerView>(R.id.recycle_view_biceps)
        val listBiceps = ArrayList<Biceps>()
        var adapter = BycipesAdapter(this, listBiceps)
        recyclerViewBiceps.adapter = adapter

        ListEntityGenericAsync<Biceps>(this, listBiceps, adapter, 0).execute()
    }
}
