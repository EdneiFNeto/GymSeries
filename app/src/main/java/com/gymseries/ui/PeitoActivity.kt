package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.PeitoAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Peito

class PeitoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peito)

        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_peito)
        val peitos = ArrayList<Peito>()
        var adapter = PeitoAdapter(this, peitos, true)
        recyclerViewTriceps.adapter = adapter

        ListEntityGenericAsync<Peito>(this, peitos, adapter, 2).execute()
    }
}
