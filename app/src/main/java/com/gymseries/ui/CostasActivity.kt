package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.CostasAdapter
import com.gymseries.async.ListarCostaAsync
import com.gymseries.async.ListarOmbrosAsync
import com.gymseries.model.Costa

class CostasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_costas)

        var recyclerView = findViewById<RecyclerView>(R.id.recycle_view_costas)
        val costas = ArrayList<Costa>()
        var adapter = CostasAdapter(this, costas)
        recyclerView.adapter = adapter
        ListarCostaAsync(this, costas, adapter).execute()
    }
}
