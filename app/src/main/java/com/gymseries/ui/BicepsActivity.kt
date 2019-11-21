package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Biceps

class BicepsActivity : AppCompatActivity() {

    private val op: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biceps_triceps)

        var recyclerViewBiceps = findViewById<RecyclerView>(R.id.recycle_view_biceps)
        val biceps = ArrayList<Biceps>()

        var adapter:MyGenericAdapter<Biceps> = MyGenericAdapter(this, biceps, op, true)
        recyclerViewBiceps.adapter = adapter

        ListEntityGenericAsync(this, biceps, adapter, op).execute()
    }
}
