package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.async.UpdateTricepsAsync
import com.gymseries.model.Triceps

class TricepsAdapter(val context: Context, private var triceps: ArrayList<Triceps>, private val changeLayout:Boolean ) :
    RecyclerView.Adapter<TricepsAdapter.MyHolder>() {

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
        return triceps.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val tricep = triceps[position]
        holder.add(tricep)

        if (changeLayout) {
            if (tricep.status) {
                holder.itemView.setBackgroundResource(R.color.colorAccent)
            } else {
                holder.itemView.setBackgroundResource(android.R.color.transparent)
            }

            holder.itemView.setOnClickListener {
                dialog(tricep, triceps)
            }
        }else{
            holder.repeticao.text = tricep.repeticoes
            holder.peso.text = tricep.peso
        }
    }
    
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title =  itemView.findViewById<TextView>(R.id.text_title_treino)
        var repeticao =  itemView.findViewById<TextView>(R.id.text_num_repeticao)
        var peso =  itemView.findViewById<TextView>(R.id.text_kg)

        fun add(t: Triceps) {
            title.text = t.descr
            repeticao.text= "Repetições ${t.repeticoes}"
            peso.text="Kg: ${t.peso}"
        }
    }


    fun dialog(triceps: Triceps, listTriceps: ArrayList<Triceps>) {

        //exeibe dialog para opcao de treinos
        var builder = AlertDialog.Builder(context)
        builder.setIcon(R.mipmap.ic_descri_treino)
        val title = triceps.descr
        builder.setTitle(title)

        val view: View = LayoutInflater.from(context).inflate(R.layout.layout_select_peso_repeticao_treino, null)
        var edittext_kg = view.findViewById<EditText>(R.id.edttext_kg)
        var edittext_num_repeticao = view.findViewById<EditText>(R.id.edittext_repeticao)
        var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)
        var status = view.findViewById<Switch>(R.id.switch_is_enabled)

        edittext_kg.setText(triceps.peso)
        edittext_num_repeticao.setText(triceps.repeticoes)

        if(triceps.status)
            status.isChecked = true

        builder.setView(view)
        var dialog = builder.create()
        dialog.show()

        button_salvar.setOnClickListener {

            UpdateTricepsAsync(
                context,
                Triceps(
                    id = triceps.id,
                    status = status.isChecked,
                    repeticoes = edittext_num_repeticao.text.toString(),
                    peso = edittext_kg.text.toString(),
                    descr = triceps.descr
                ),
                this,
                listTriceps
            ).execute()

            dialog.dismiss()
        }
    }
}

