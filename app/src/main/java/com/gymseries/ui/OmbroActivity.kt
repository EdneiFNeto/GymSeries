package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.MyGenericAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.Ombro
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class OmbroActivity : AppCompatActivity() {
    private val op: Int = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ombro)

        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_ombro).toUpperCase()
        )

        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_ombro)
        val ombros = ArrayList<Ombro>()
        var adapter = MyGenericAdapter(this, ombros, op, true)
        recyclerViewTriceps.adapter = adapter

        ListEntityGenericAsync<Ombro>(this, ombros, adapter, op).execute()
    }
}
