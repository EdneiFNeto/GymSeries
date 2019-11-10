package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.model.Triceps
import com.gymseries.utils.ResourcesUtils

class Tricesctivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tricesctivity)

        var recyclerViewTriceps = findViewById<RecyclerView>(R.id.recycle_view_triceps)

        var triceps:Array<Triceps> = arrayOf(
            Triceps(ResourcesUtils.getString(this, R.string.testa)),
            Triceps(ResourcesUtils.getString(this, R.string.supinado)),
            Triceps(ResourcesUtils.getString(this, R.string.mergulho)),
            Triceps(ResourcesUtils.getString(this, R.string.triceps_no_banco)),
            Triceps(ResourcesUtils.getString(this, R.string.extencao_alter_sob_cabeca)),
            Triceps(ResourcesUtils.getString(this, R.string.tirceps_barra_alta)),
            Triceps(ResourcesUtils.getString(this, R.string.tirceps_corda))
        )

        var adapterTriceps = TricepsAdapter(this, triceps)
        recyclerViewTriceps.adapter = adapterTriceps

    }
}
