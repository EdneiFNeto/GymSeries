package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Perna
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class PernaActivity : AppCompatActivity() {

    private val op: Int = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perna_activity)


        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_perna).toUpperCase()
        )


        var recyclerView = findViewById<RecyclerView>(R.id.recycle_view_perna)
        val pernas = ArrayList<Perna>()
        var adapter = MyGenericAdapter(this, pernas, op, true)
        recyclerView.adapter = adapter

        ListEntityGenericAsync(this, pernas, adapter, op).execute()
    }
}
