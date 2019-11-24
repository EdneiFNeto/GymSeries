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
import com.gymseries.generics.async.UpdateGeneric

abstract class BaseAdapter<T>(
    val context: Context?,
    private val list: ArrayList<T>,
    val op: Int,
    val changeLayout: Boolean
) : RecyclerView.Adapter<BaseAdapter.MyHolder<T>>() {

    var TAG = "BaseAdapterLog"

    override fun onBindViewHolder(holder: MyHolder<T>, position: Int) {
        holder.add(list[position])
        if (changeLayout) {
            if (holder.status == "true") {
                holder.itemView.setBackgroundResource(R.color.primaryColor)
            } else {
                holder.itemView.setBackgroundResource(android.R.color.white)
            }

            holder.itemView.setOnClickListener {
                dialog(list[position])
            }

        } else {
            convertStringFronModel(holder, list[position])

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder<T> {


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
                    R.layout.layout_serie,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var status: String
        var title = itemView.findViewById<TextView>(R.id.text_title_treino)
        var repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)
        var peso = itemView.findViewById<TextView>(R.id.text_kg)

        fun add(t: T) {
            var str = t.toString().split(",")
            for (i in 0..str.size) {
                when (i) {
                    1 -> title.text = str[i]
                    2 -> repeticao.text = "3 x ${str[i]} Rept."
                    3 -> peso.text = " ${str[i]} Kg."
                    4 -> status = str[i]
                }
            }
        }
    }

    fun dialog(t: T) {

        var str = t.toString().split(",")
        var title = ""
        var repeticao = ""
        var peso = ""
        var mySatutus = ""

        for (i in 0..str.size) {
            when (i) {
                1 -> title = str[i]
                2 -> repeticao = str[i]
                3 -> peso = str[i]
                4 -> mySatutus = str[i]
            }
        }

        //exeibe dialog para opcao de treinos
        if (context != null) {
            var builder = AlertDialog.Builder(context)
            builder.setIcon(R.mipmap.ic_descri_treino)
            builder.setTitle(title)

            val view: View =
                LayoutInflater.from(context)
                    .inflate(R.layout.layout_select_peso_repeticao_treino, null)
            var edittext_kg = view.findViewById<EditText>(R.id.edttext_kg)
            var edittext_num_repeticao = view.findViewById<EditText>(R.id.edittext_repeticao)
            var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)
            var status = view.findViewById<Switch>(R.id.switch_is_enabled)

            edittext_kg.setText(peso)
            edittext_num_repeticao.setText(repeticao)
            if (mySatutus == "true") {
                status.isChecked = true
            }

            builder.setView(view)
            var dialog = builder.create()
            dialog.show()

            button_salvar.setOnClickListener {
                UpdateGeneric(
                    context,
                    status.isChecked,
                    edittext_kg,
                    edittext_num_repeticao,
                    op,
                    t,
                    list,
                    this
                ).execute()
                dialog.dismiss()
            }
        }
    }

    fun convertStringFronModel(
        holder: MyHolder<T>,
        model: T
    ) {
        var str = model.toString().split(",")
        for (i in 0..str.size) {
            when (i) {
                1 -> holder.title.text = str[i]
                2 -> holder.repeticao.text = str[i]
                3 -> holder.peso.text = str[i]
                4 -> holder.status = str[i]
            }
        }
    }
}


