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
import com.gymseries.model.Costa
import kotlin.collections.ArrayList

class CostasAdapter(val context: Context,
                    private val costas: ArrayList<Costa>) :
    RecyclerView.Adapter<CostasAdapter.MyHolder>() {

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
        return costas.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val costa = costas[position]
        holder.add(costa)

        if (costa.status) {
            holder.itemView.setBackgroundResource(R.color.colorAccent)
        } else {
            holder.itemView.setBackgroundResource(android.R.color.transparent)
        }

        holder.itemView.setOnClickListener {
            dialog(costa, costas)
        }
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title = itemView.findViewById<TextView>(R.id.text_title_treino)
        var repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)
        var peso = itemView.findViewById<TextView>(R.id.text_kg)

        fun add(costa: Costa) {
            title.text = costa.descr
            repeticao.text = "Repetições ${costa.repeticao}"
            peso.text = "Kg: ${costa.peso}"
        }
    }


    fun dialog(costa: Costa, costas: ArrayList<Costa>) {

        //exeibe dialog para opcao de treinos
        var builder = AlertDialog.Builder(context)
        builder.setIcon(R.mipmap.ic_descri_treino)
        val title = costa.descr
        builder.setTitle(title)

        val view: View =
            LayoutInflater.from(context).inflate(R.layout.layout_select_peso_repeticao_treino, null)
        var edittext_kg = view.findViewById<EditText>(R.id.edttext_kg)
        var edittext_num_repeticao = view.findViewById<EditText>(R.id.edittext_repeticao)
        var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)
        var status = view.findViewById<Switch>(R.id.switch_is_enabled)

        edittext_kg.setText(costa.peso)
        edittext_num_repeticao.setText(costa.repeticao)

        if (costa.status)
            status.isChecked = true

        builder.setView(view)
        var dialog = builder.create()
        dialog.show()

        button_salvar.setOnClickListener {

            /*UpdateCostasAsyncAsync(
                context,
                Costa(
                    id = costa.id,
                    status = status.isChecked,
                    repeticao = edittext_num_repeticao.text.toString(),
                    peso = edittext_kg.text.toString(),
                    descr = costa.descr
                ),
                this,
                costas
            ).execute()*/

            dialog.dismiss()
        }
    }
}
