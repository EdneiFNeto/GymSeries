package com.gymseries.fragments

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.adapter.UserAdapter
import com.gymseries.generics.async.ListEntityGenericAsync
import com.gymseries.model.User
import com.gymseries.utils.ActionBarUtils
import com.gymseries.utils.DataUtils
import com.gymseries.utils.FormatUtils
import com.gymseries.utils.ResourcesUtils


class IMCFragments : Fragment() {

    private lateinit var adapter: UserAdapter
    private var users: ArrayList<User> = arrayListOf()
    private var sexo: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var supportActionBar = (activity as AppCompatActivity).supportActionBar
        ActionBarUtils.title(
            supportActionBar,
            ResourcesUtils.getString(context, R.string.title_imc))

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = LayoutInflater.from(context).inflate(R.layout.activity_imc, container, false)
        var recyclerView = myView.findViewById<RecyclerView>(R.id.recycle_view_imc)
        adapter = UserAdapter(context, users)
        recyclerView.adapter = adapter


        ListEntityGenericAsync(context, users, adapter,
            ResourcesUtils.getString(context, R.string.op_user)).execute()

        return myView
    }

    private fun calcularIMC(
        peso: EditText?,
        altura: EditText?,
        resultadoImc: EditText?,
        sexo: String
    ) {

        var p = peso?.text.toString()
        var a = altura?.text.toString()
        var imc = p.toDouble() / (a.toDouble() * a.toDouble())

        resultadoImc?.setTextColor(resources.getColor(android.R.color.black))
        var imcFormatado = FormatUtils.formatarMoeda(imc)
        var resultado = ""

//        resultado = validaResultado(imc, resultado, imcFormatado, resultadoImc)
//
//        users.add(
//            User(
//                title = 0L,
//                peso = p.toDouble(),
//                altura = a.toDouble(),
//                sexo = sexo,
//                data = DataUtils.getDataAtualHora(),
//                resultado = resultado,
//                imc = imcFormatado
//            )
//        )

//        InsertIMC(context, users, adapter).execute()
    }


    private fun validaResultado(
        imc: Double,
        resultado: String,
        resultadoImc: EditText?
    ): String {
        var resultado1 = resultado
        if (imc < 18.5) {
            resultado1 = ResourcesUtils.getString(context, R.string.peso_baixo)
            resultadoImc?.setText(resultado1)
            resultadoImc?.setBackgroundColor(resources.getColor(R.color.colorYellow))
        } else if (imc > 18.5 && imc <= 24.9) {
            resultado1 = ResourcesUtils.getString(context, R.string.peso_normal)
            resultadoImc?.setText(resultado1)
            resultadoImc?.setBackgroundColor(resources.getColor(R.color.colorGreen))
        } else if (imc > 24.9 && imc <= 29.9) {
            resultado1 = ResourcesUtils.getString(context, R.string.sobre_peso)
            resultadoImc?.setText(resultado1)
            resultadoImc?.setBackgroundColor(resources.getColor(R.color.colorPele))
        } else if (imc > 29.9 && imc <= 34.9) {
            resultado1 = ResourcesUtils.getString(context, R.string.sobre_peso_g1)
            resultadoImc?.setText(resultado1)
            resultadoImc?.setBackgroundColor(resources.getColor(R.color.colorOrange))
        } else if (imc > 34.9 && imc <= 39.9) {
            resultado1 = ResourcesUtils.getString(context, R.string.sobre_peso_g2)
            resultadoImc?.setText(resultado1)
            resultadoImc?.setBackgroundColor(resources.getColor(R.color.colorRed))
        } else if (imc > 39.9) {
            resultado1 = ResourcesUtils.getString(context, R.string.sobre_peso_g2)
            resultadoImc?.setText(resultado1)
            resultadoImc?.setBackgroundColor(resources.getColor(R.color.colorRedI))
        }
        return resultado1
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        val item = menu.add(ResourcesUtils.getString(context, R.string.title_dialof_calc_imc))
        item.setIcon(R.drawable.ic_calculator)
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        item.setOnMenuItemClickListener {

            if (context != null) {

                var builder = AlertDialog.Builder(context!!)
                builder.setIcon(R.drawable.ic_calculator_black)
                builder.setTitle(ResourcesUtils.getString(context, R.string.title_calcular_imc))
                val myView = LayoutInflater.from(context).inflate(R.layout.layout_dialog_imc, null)
                builder.setView(myView)

                var peso = myView.findViewById<EditText>(R.id.edt_text_peso_imc)
                var altura = myView.findViewById<EditText>(R.id.edt_text_altura_imc)
                var button_calcular_imc = myView.findViewById<Button>(R.id.button_calcular_imc)
                var dialog = builder.create()

                button_calcular_imc.setOnClickListener {

                    if (peso.text.toString().isNotEmpty() && altura.text.toString().isNotEmpty()) {
                    //calcularIMC(peso, altura, result_imc, sexo)
                    } else
                        Toast.makeText(context, ResourcesUtils.getString(context, R.string.preencha_campos),Toast.LENGTH_SHORT
                        ).show()

                    dialog.dismiss()
                }
                dialog.show()
            }

            true
        }

        super.onCreateOptionsMenu(menu, inflater)
    }
}
