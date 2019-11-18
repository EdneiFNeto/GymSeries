package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.PeitoAdapter
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.async.ListarPeitoAsync
import com.gymseries.async.ListarTricepsAsyncTasks
import com.gymseries.model.Peito
import com.gymseries.model.Triceps

class PeitoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peito)

        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_peito)
        val peitos = ArrayList<Peito>()
        var adapter = PeitoAdapter(this, peitos, true)
        recyclerViewTriceps.adapter = adapter

        ListarPeitoAsync(this, peitos, adapter).execute()
    }
}
