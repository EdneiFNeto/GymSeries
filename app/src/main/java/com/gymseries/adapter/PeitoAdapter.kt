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
import com.gymseries.model.Peito

class PeitoAdapter(
    val context: Context,
    private val peitos: ArrayList<Peito>,
    private val changeLayout: Boolean
) : RecyclerView.Adapter<PeitoAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        if (changeLayout) {
            return MyHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.activity_treino,
                    parent,
                    false
                )
            )

        } else {
            return MyHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.activity_serie_adapter,
                    parent,
                    false
                )
            )
        }

    }

    override fun getItemCount(): Int {
        return peitos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val peito = peitos[position]
        holder.add(peito)

        if (changeLayout) {
            if (peito.status) {
                holder.itemView.setBackgroundResource(R.color.colorAccent)
            } else {
                holder.itemView.setBackgroundResource(android.R.color.transparent)
            }

            holder.itemView.setOnClickListener {
                dialog(peito, peitos)
            }
        }else{
            holder.repeticao.text = peito.repeticao
            holder.peso.text = peito.peso
        }
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title = itemView.findViewById<TextView>(R.id.text_title_treino)
        var repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)
        var peso = itemView.findViewById<TextView>(R.id.text_kg)

        fun add(peito: Peito) {
            title.text = peito.descr
            repeticao.text = "Repetições ${peito.repeticao}"
            peso.text = "Kg: ${peito.peso}"
        }
    }


    fun dialog(peito: Peito, peitos: ArrayList<Peito>) {

        //exeibe dialog para opcao de treinos
        var builder = AlertDialog.Builder(context)
        builder.setIcon(R.mipmap.ic_descri_treino)
        val title = peito.descr
        builder.setTitle(title)

        val view: View =
            LayoutInflater.from(context).inflate(R.layout.layout_select_peso_repeticao_treino, null)
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

            /*UpdatePeitoAsyncAsync(
                context,
                Peito(
                    id = peito.id,
                    status = status.isChecked,
                    repeticao = edittext_num_repeticao.text.toString(),
                    peso = edittext_kg.text.toString(),
                    descr = peito.descr
                ),
                this,
                peitos
            ).execute()*/

            dialog.dismiss()
        }
    }
}