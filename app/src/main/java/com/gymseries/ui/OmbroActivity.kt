package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.OmbroAdapter
import com.gymseries.adapter.PeitoAdapter
import com.gymseries.async.ListarOmbrosAsync
import com.gymseries.async.ListarPeitoAsync
import com.gymseries.model.Ombro
import com.gymseries.model.Peito

class OmbroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ombro)
        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_ombro)
        val ombros = ArrayList<Ombro>()
        var adapter = OmbroAdapter(this, ombros)
        recyclerViewTriceps.adapter = adapter
        ListarOmbrosAsync(this, ombros, adapter).execute()
    }
}
