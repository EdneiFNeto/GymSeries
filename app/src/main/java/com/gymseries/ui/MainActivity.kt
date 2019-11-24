package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.IntensAdapter
import com.gymseries.model.Itens
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActionBarUtils.createTitleActionBar(
            supportActionBar,
            ResourcesUtils.getString(this, R.string.title_app).toUpperCase()
        )


        var recyclerView = findViewById<RecyclerView>(R.id.recycle_view_main)

        var listItens = arrayOf(
            Itens(
                R.drawable.biceps,
                ResourcesUtils.getString(this, R.string.braco),
                ResourcesUtils.getString(this, R.string.biceps)
            ),
            Itens(
                R.drawable.triceps,
                ResourcesUtils.getString(this, R.string.braco),
                ResourcesUtils.getString(this, R.string.triceps)
            ),
            Itens(
                R.drawable.peito,
                ResourcesUtils.getString(this, R.string.serie_peito),
                ResourcesUtils.getString(this, R.string.peito)
            ),
            Itens(
                R.drawable.ombro,
                ResourcesUtils.getString(this, R.string.serie_ombro),
                ResourcesUtils.getString(this, R.string.ombro)
            ),
            Itens(
                R.drawable.costas,
                ResourcesUtils.getString(this, R.string.serie_costas),
                ResourcesUtils.getString(this, R.string.costas)
            ),
            Itens(
                R.drawable.pernas,
                ResourcesUtils.getString(this, R.string.serie_perna),
                ResourcesUtils.getString(this, R.string.perna)
            ),
            Itens(
                R.drawable.imc,
                ResourcesUtils.getString(this, R.string.imc),
                ResourcesUtils.getString(this, R.string.imc)
            ),
            Itens(
                R.drawable.imc,
                ResourcesUtils.getString(this, R.string.view_serie),
                ResourcesUtils.getString(this, R.string.view_serie)
            )
        )

        var adapter = IntensAdapter(this, listItens)
        recyclerView.adapter = adapter
    }
}
