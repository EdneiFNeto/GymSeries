package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.async.UpdateOmbroAsyncAsync
import com.gymseries.model.Ombro
import java.util.*

class OmbroAdapter(val context: Context, private val ombros: ArrayList<Ombro>) :
    RecyclerView.Adapter<OmbroAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_treino,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return ombros.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val ombro = ombros[position]
        holder.add(ombro)

        if (ombro.status) {
            holder.itemView.setBackgroundResource(R.color.colorAccent)
        } else {
            holder.itemView.setBackgroundResource(android.R.color.transparent)
        }

        holder.itemView.setOnClickListener {
            dialog(ombro, ombros)
        }
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title = itemView.findViewById<TextView>(R.id.text_title_treino)
        var repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)
        var peso = itemView.findViewById<TextView>(R.id.text_kg)

        fun add(ombro: Ombro) {
            title.text = ombro.descr
            repeticao.text = "Repetições ${ombro.repeticao}"
            peso.text = "Kg: ${ombro.peso}"
        }
    }


    fun dialog(ombro: Ombro, ombros: ArrayList<Ombro>) {

        //exeibe dialog para opcao de treinos
        var builder = AlertDialog.Builder(context)
        builder.setIcon(R.mipmap.ic_descri_treino)
        val title = ombro.descr
        builder.setTitle(title)

        val view: View =
            LayoutInflater.from(context).inflate(R.layout.layout_select_peso_repeticao_treino, null)
        var edittext_kg = view.findViewById<EditText>(R.id.edttext_kg)
        var edittext_num_repeticao = view.findViewById<EditText>(R.id.edittext_repeticao)
        var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)
        var status = view.findViewById<Switch>(R.id.switch_is_enabled)

        edittext_kg.setText(ombro.peso)
        edittext_num_repeticao.setText(ombro.repeticao)

        if (ombro.status)
            status.isChecked = true

        builder.setView(view)
        var dialog = builder.create()
        dialog.show()

        button_salvar.setOnClickListener {

            UpdateOmbroAsyncAsync(
                context,
                Ombro(
                    id = ombro.id,
                    status = status.isChecked,
                    repeticao = edittext_num_repeticao.text.toString(),
                    peso = edittext_kg.text.toString(),
                    descr = ombro.descr
                ),
                this,
                ombros
            ).execute()

            dialog.dismiss()
        }
    }
}