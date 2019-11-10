package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.BycipesAdapter
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.model.Biceps
import com.gymseries.model.Triceps
import com.gymseries.utils.ResourcesUtils

class BicepsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biceps_triceps)


        var recyclerViewBiceps = findViewById<RecyclerView>(R.id.recycle_view_biceps)

        var listBiceps:Array<Biceps> = arrayOf(
            Biceps(ResourcesUtils.getString(this, R.string.barra_fixa_com_pegada_supinada)),
            Biceps(ResourcesUtils.getString(this, R.string.rosca_direta)),
            Biceps(ResourcesUtils.getString(this, R.string.rosca_martelo)),
            Biceps(ResourcesUtils.getString(this, R.string.rosca_concentrada)),
            Biceps(ResourcesUtils.getString(this, R.string.rosca_inversa))
        )

        var adapterBiceps = BycipesAdapter(this, listBiceps)
        recyclerViewBiceps.adapter = adapterBiceps



    }
}
