package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Peito
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class PeitoActivity : AppCompatActivity() {

    private val op: Int = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peito)

        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_perna).toUpperCase()
        )
        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_peito)
        val peitos = ArrayList<Peito>()
        var adapter = MyGenericAdapter(this, peitos, op, true)
        recyclerViewTriceps.adapter = adapter

        ListEntityGenericAsync<Peito>(this, peitos, adapter, op).execute()
    }
}
