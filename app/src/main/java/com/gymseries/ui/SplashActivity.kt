package com.gymseries.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gymseries.R
import com.gymseries.generics.InserGenericAsync
import com.gymseries.model.Biceps
import com.gymseries.utils.ResourcesUtils

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        var biceps = arrayListOf<Biceps>(
            Biceps(
                id = 1,
                descr = ResourcesUtils.getString(this, R.string.barra_fixa_com_pegada_supinada),
                status = false,
                repeticoes = "",
                peso = ""
            ),
            Biceps(
                id = 2,
                descr = ResourcesUtils.getString(this, R.string.rosca_direta),
                status = false,
                repeticoes = "",
                peso = ""
            ),
            Biceps(
                id = 3,
                descr = ResourcesUtils.getString(this, R.string.rosca_martelo),
                status = false,
                repeticoes = "",
                peso = ""
            ),
            Biceps(
                id = 4,
                descr = ResourcesUtils.getString(this, R.string.rosca_concentrada),
                status = false,
                repeticoes = "",
                peso = ""
            ),
            Biceps(
                id = 5,
                descr = ResourcesUtils.getString(this, R.string.rosca_inversa),
                status = false,
                repeticoes = "",
                peso = ""
            )
        )

        InserGenericAsync(this,  0, biceps).execute()
    }
}
