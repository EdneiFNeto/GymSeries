package com.gymseries.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gymseries.R
import com.gymseries.generics.InserGenericAsync
import com.gymseries.model.*
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.ResourcesUtils

class SplashActivity : AppCompatActivity() {

    val TAG = "SplashActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ActionBarUtils.hide(supportActionBar)
        Handler().postDelayed({
            initThreads()
        }, 3000)
    }

    private fun initThreads() {

        var biceps = arrayListOf<Biceps>(
            Biceps(
                id = 1,
                descr = ResourcesUtils.getString(this, R.string.barra_fixa_com_pegada_supinada),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Biceps(
                id = 2,
                descr = ResourcesUtils.getString(this, R.string.rosca_direta),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null

            ),
            Biceps(
                id = 3,
                descr = ResourcesUtils.getString(this, R.string.rosca_martelo),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null

            ),
            Biceps(
                id = 4,
                descr = ResourcesUtils.getString(this, R.string.rosca_concentrada),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Biceps(
                id = 5,
                descr = ResourcesUtils.getString(this, R.string.rosca_inversa),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            )
        )
        var triceps = arrayListOf<Triceps>(

            Triceps(
                id = 1,
                descr = ResourcesUtils.getString(this, R.string.triceps_no_banco),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Triceps(
                id = 2,
                descr = ResourcesUtils.getString(this, R.string.tirceps_corda),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Triceps(
                id = 3,
                descr = ResourcesUtils.getString(this, R.string.extencao_alter_sob_cabeca),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Triceps(
                id = 4,
                descr = ResourcesUtils.getString(this, R.string.triceps_testa),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Triceps(
                id = 5,
                descr = ResourcesUtils.getString(this, R.string.mergulho),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            )
        )
        var costas = arrayListOf<Costa>(
            Costa(
                id = 5,
                descr = ResourcesUtils.getString(this, R.string.barra_fixa),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ), Costa(
                id = 5,
                descr = ResourcesUtils.getString(this, R.string.barra_fixa),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            )
        )
        var pernas = arrayListOf<Perna>(

            Perna(
                id = 1,
                descr = ResourcesUtils.getString(this, R.string.extencao_alter_sob_cabeca),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Perna(
                id = 2,
                descr = ResourcesUtils.getString(this, R.string.agaichamento_livre),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Perna(
                id = 3,
                descr = ResourcesUtils.getString(this, R.string.extensora),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            )
        )
        var ombros = arrayListOf<Ombro>(

            Ombro(
                id = 2,
                descr = ResourcesUtils.getString(this, R.string.ombro_alternada),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Ombro(
                id = 3,
                descr = ResourcesUtils.getString(this, R.string.ombro_remada_aparelho),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            )
        )
        var peito = arrayListOf<Peito>(

            Peito(
                id = 2,
                descr = ResourcesUtils.getString(this, R.string.supino_reto),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            ),
            Peito(
                id = 3,
                descr = ResourcesUtils.getString(this, R.string.supino_45),
                status = false,
                repeticoes = "",
                peso = "",
                serie = null
            )
        )

        Thread(Runnable {
            Log.e(TAG, "Executando thread 0")
            InserGenericAsync(this, 0, biceps).execute()

            Thread(Runnable {

                Log.e(TAG, "Executando thread 1")
                InserGenericAsync(this, 1, triceps).execute()

                Thread(Runnable {

                    Log.e(TAG, "Executando thread 2")
                    InserGenericAsync(this, 2, peito).execute()

                    Thread(Runnable {

                        Log.e(TAG, "Executando thread 3")
                        InserGenericAsync(this, 3, ombros).execute()

                        Thread(Runnable {

                            Log.e(TAG, "Executando thread 4")
                            InserGenericAsync(this, 4, costas).execute()

                            Thread(Runnable {
                                Log.e(TAG, "Executando thread 5")
                                InserGenericAsync(this, 5, pernas).execute()
                                startActivity(Intent(this, MainActivity::class.java))

                            }).start()
                        }).start()
                    }).start()
                }).start()
            }).start()
        }).start()
    }
}
