package com.gymseries.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gymseries.R
import com.gymseries.async.InsertUsers
import com.gymseries.generics.InserGenericAsync
import com.gymseries.interfaces.onListener
import com.gymseries.model.User
import com.gymseries.utils.DataUtils
import com.gymseries.utils.ResourcesUtils
import kotlinx.android.synthetic.main.activity_form_init.*

class FormInitActivity : AppCompatActivity(), onListener {

    private lateinit var sexo: String
    private val TAG: String = "FormInitActivityLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_init)
    }

    override fun onResume() {
        super.onResume()
        button_salvar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.button_salvar -> salvar()
        }
    }

    private fun salvar() {

        var altura = text_altura.text.toString()
        var peso = text_peso.text.toString()
        sexo = when {
            radio_sexo_feminino.isChecked -> "F"
            radio_sexo_masculino.isChecked -> "M"
            else -> ""
        }

        var resultado = peso.toDouble()/(altura.toDouble()* altura.toDouble())

        var user = User(0L, altura.toDouble(), peso.toDouble(), sexo, resultado.toString(),
            DataUtils.getDataAtualHora(), resultado.toString())

        InsertUsers(this, user).execute()
    }
}
