package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Peito
import java.util.*

class PeitoSelecionadoAdapter(val context: Context, private val peitos: ArrayList<Peito>) :
    RecyclerView.Adapter<PeitoSelecionadoAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_serie_adapter,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return peitos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        var peito:Peito =  peitos[position]
        holder.add(peito)

        if (peito.status) {
            holder.itemView.setBackgroundResource(R.color.colorAccent)
        } else {
            holder.itemView.setBackgroundResource(android.R.color.transparent)
        }

        holder.itemView.setOnClickListener {
            dialog(peito, peitos)
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text_title_treino = itemView.findViewById<TextView>(R.id.text_title_treino)
        val text_kg = itemView.findViewById<TextView>(R.id.text_kg)
        val text_num_repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)

        fun add(peito: Peito) {
            text_title_treino.text = peito.descr
            text_kg.text = "Peso: ${peito.peso}"
            text_num_repeticao.text ="Repetição: ${peito.repeticao}"
        }
    }

    fun dialog(peito: Peito, peitos: ArrayList<Peito>) {

        //exeibe dialog para opcao de treinos
        var builder = AlertDialog.Builder(context)
        builder.setIcon(R.mipmap.ic_descri_treino)
        val title = peito.descr
        builder.setTitle(title)

        val view: View =
            LayoutInflater.from(context)
                .inflate(R.layout.layout_select_peso_repeticao_treino, null)
        var edittext_kg = view.findViewById<EditText>(R.id.edttext_kg)
        var edittext_num_repeticao = view.findViewById<EditText>(R.id.edittext_repeticao)
        var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)
        var status = view.findViewById<Switch>(R.id.switch_is_enabled)

        edittext_kg.setText(peito.peso)
        edittext_num_repeticao.setText(peito.repeticao)

        if (peito.status)
            status.isChecked = true

        builder.setView(view)
        var dialog = builder.create()
        dialog.show()

        button_salvar.setOnClickListener {

            var p = Peito(
                id = peito.id,
                status = status.isChecked,
                repeticao = edittext_num_repeticao.text.toString(),
                peso = edittext_kg.text.toString(),
                descr = peito.descr
            )

            dialog.dismiss()
        }
    }

}
