package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.CostasAdapter
import com.gymseries.adapter.PernaAdapter
import com.gymseries.async.ListarCostaAsync
import com.gymseries.async.ListarPernasAsync
import com.gymseries.model.Costa
import com.gymseries.model.Perna

class PernaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perna_activity)

        var recyclerView = findViewById<RecyclerView>(R.id.recycle_view_perna)
        val pernas = ArrayList<Perna>()
        var adapter = PernaAdapter(this, pernas, true)
        recyclerView.adapter = adapter

        ListarPernasAsync(this, pernas, adapter).execute()
    }
}
