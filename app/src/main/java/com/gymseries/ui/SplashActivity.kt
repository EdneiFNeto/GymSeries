package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gymseries.R
import com.gymseries.async.InserBicepsAsyncTasks
import com.gymseries.model.Biceps
import com.gymseries.utils.ResourcesUtils

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var biceps = arrayOf(
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

        InserBicepsAsyncTasks(this, biceps).execute()
    }
}
