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
            Biceps(id = 1, descr = ResourcesUtils.getString(this, R.string.barra_fixa_com_pegada_supinada), status = false, pepeticao = "0", peso = "0"),
            Biceps(id = 2, descr = ResourcesUtils.getString(this, R.string.rosca_direta), status = false, pepeticao = "0", peso = "0"),
            Biceps(id = 3, descr = ResourcesUtils.getString(this, R.string.rosca_martelo), status = false, pepeticao = "0", peso = "0"),
            Biceps(id = 4, descr = ResourcesUtils.getString(this, R.string.rosca_concentrada), status = false, pepeticao = "0", peso = "0"),
            Biceps(id = 5, descr = ResourcesUtils.getString(this, R.string.rosca_inversa), status = false, pepeticao = "0", peso = "0")
        )

        InserBicepsAsyncTasks(this, biceps).execute()
    }
}
