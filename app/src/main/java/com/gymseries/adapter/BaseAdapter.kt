package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.generics.DeleteEntityGenericAsync
import com.gymseries.generics.async.UpdateGeneric
import com.gymseries.model.*
import com.gymseries.utils.LayoutUtils
import com.gymseries.utils.ResourcesUtils

abstract class BaseAdapter<T>(
    val context: Context?,
    private val list: ArrayList<T>,
    val op: String,
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

            holder.itemView.setOnLongClickListener {
                if (context != null) {
                    dialogDelete(context, holder.id, holder)
                }
                true
            }

        } else {
            convertStringFronModel(holder, list[position])
            holder.repeticao.text = if (holder.repeticao.text.toString() != "") "3, 4 ou 6 x ${holder.repeticao.text} Rept." else "3 ou 4 x 0 Rept."
            holder.peso.text = if (holder.peso.text != "") "${holder.peso.text}  Kg." else "0 Kg"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder<T> {
        return if (changeLayout) {
            MyHolder(LayoutUtils.inflateLayout(context, parent, R.layout.activity_treino))
        } else {
            MyHolder(LayoutUtils.inflateLayout(context, parent, R.layout.layout_serie))
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    class MyHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var id: String
        lateinit var status: String
        var serie: String? = null
        var title = itemView.findViewById<TextView>(R.id.text_title_treino)
        var repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)
        var peso = itemView.findViewById<TextView>(R.id.text_kg)

        fun add(t: T) {
            var str = t.toString().split(",")
            for (i in 0..str.size) {
                when (i) {
                    0 -> id = str[i]
                    1 -> title.text = str[i]
                    2 -> repeticao.text = if (str[i] != "") "3, 4 ou 6 x ${str[i]} Rept." else "0 Rept."
                    3 -> peso.text = if (str[i] != "") "${str[i]} Kg." else "0 Kg"
                    5 -> status = str[i]
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
        var serie = ""

        for (i in 0..str.size) {
            when (i) {
                1 -> title = str[i]
                2 -> repeticao = str[i]
                3 -> peso = str[i]
                4 -> serie = str[i]
                5 -> mySatutus = str[i]
            }
        }

        //show dialog para options de treino
        if (context != null) {

            var builder = AlertDialog.Builder(context)
            builder.setIcon(R.drawable.ic_serie)
            builder.setTitle(title)

            val view: View = LayoutInflater.from(context) .inflate(R.layout.layout_select_peso_repeticao_treino, null)
            var edittext_peso = view.findViewById<EditText>(R.id.edttext_kg)
            var edittext_num_repeticao = view.findViewById<EditText>(R.id.edittext_repeticao)
            var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)
            var status = view.findViewById<Switch>(R.id.switch_is_enabled)
            var radio_serie_a = view.findViewById<RadioButton>(R.id.radio_serie_a)
            var radio_serie_b = view.findViewById<RadioButton>(R.id.radio_serie_b)

            if(serie == ResourcesUtils.getString(context, R.string.a)){
                radio_serie_a.isChecked = true
            }else if (serie == ResourcesUtils.getString(context, R.string.b)){
                radio_serie_b.isChecked = true
            }

            radio_serie_a.setOnClickListener {
                if (radio_serie_a.isChecked)
                    serie = ResourcesUtils.getString(context, R.string.a)
            }
            radio_serie_b.setOnClickListener {
                if (radio_serie_b.isChecked)
                    serie = ResourcesUtils.getString(context, R.string.b)
            }

            edittext_peso.setText(peso)
            edittext_num_repeticao.setText(repeticao)

            if (mySatutus == "true") {
                status.isChecked = true
            }

            builder.setView(view)
            var dialog = builder.create()
            dialog.show()

            button_salvar.setOnClickListener {

                UpdateGeneric(context, status.isChecked, edittext_peso,
                    edittext_num_repeticao, serie, op, t, list,this).execute()

                dialog.dismiss()
            }
        }
    }

    fun onRadioButtonClicked(itemView: View) {

        when (itemView.id) {
            R.id.radio_serie_a -> {
                var serieA = itemView.findViewById<RadioButton>(R.id.radio_serie_a)
                if (serieA.isChecked) {
                }
            }
            R.id.radio_serie_b -> {
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
                4 -> holder.serie = str[i]
                5 -> holder.status = str[i]
            }
        }
    }

    fun dialogDelete(context: Context, id: String, holder: MyHolder<T>) {

        var dialog = AlertDialog.Builder(context)
        dialog.setIcon(R.drawable.ic_delete)
        dialog.setTitle(ResourcesUtils.getString(context, R.string.deletar_serie))
        dialog.setMessage(ResourcesUtils.getString(context, R.string.msg_delete))
        dialog.setCancelable(false)

        dialog.setPositiveButton(
            ResourcesUtils.getString(
                context,
                R.string.button_confirmar
            )
        ) { dialog, _ ->

            when (op) {
                ResourcesUtils.getString(context, R.string.op_biceps) -> {
                    DeleteEntityGenericAsync(
                        context, 0, Biceps(
                            id = id.toLong(),
                            descr = holder.title.text.toString(),
                            status = holder.status.toBoolean(),
                            repeticoes = holder.repeticao.text.toString(),
                            peso = holder.peso.text.toString(),
                            serie = holder.serie
                        ), list = list as ArrayList<Biceps>, adapter = this
                    ).execute()
                }
                ResourcesUtils.getString(context, R.string.op_triceps) -> {
                    DeleteEntityGenericAsync(
                        context, 1, Triceps(
                            id = id.toLong(),
                            descr = holder.title.text.toString(),
                            status = holder.status.toBoolean(),
                            repeticoes = holder.repeticao.text.toString(),
                            peso = holder.peso.text.toString(),
                            serie = holder.serie
                        ), list = list as ArrayList<Triceps>, adapter = this
                    ).execute()
                }
                ResourcesUtils.getString(context, R.string.op_peito) -> {
                    DeleteEntityGenericAsync(
                        context, 2, Peito(
                            id = id.toLong(),
                            descr = holder.title.text.toString(),
                            status = holder.status.toBoolean(),
                            repeticoes = holder.repeticao.text.toString(),
                            peso = holder.peso.text.toString(),
                            serie = holder.serie
                        ), list = list as ArrayList<Peito>, adapter = this
                    ).execute()
                }
                ResourcesUtils.getString(context, R.string.op_ombro) -> {
                    DeleteEntityGenericAsync(
                        context, 3, Ombro(
                            id = id.toLong(),
                            descr = holder.title.text.toString(),
                            status = holder.status.toBoolean(),
                            repeticoes = holder.repeticao.text.toString(),
                            peso = holder.peso.text.toString(),
                            serie = holder.serie
                        ), list = list as ArrayList<Ombro>, adapter = this
                    ).execute()
                }
                ResourcesUtils.getString(context, R.string.op_costa) -> {
                    DeleteEntityGenericAsync(
                        context, 4, Costa(
                            id = id.toLong(),
                            descr = holder.title.text.toString(),
                            status = holder.status.toBoolean(),
                            repeticoes = holder.repeticao.text.toString(),
                            peso = holder.peso.text.toString(),
                            serie = holder.serie
                        ), list = list as ArrayList<Costa>, adapter = this
                    ).execute()
                }
                ResourcesUtils.getString(context, R.string.op_perna) -> {
                    DeleteEntityGenericAsync(
                        context, 5, Perna(
                            id = id.toLong(),
                            descr = holder.title.text.toString(),
                            status = holder.status.toBoolean(),
                            repeticoes = holder.repeticao.text.toString(),
                            peso = holder.peso.text.toString(),
                            serie = holder.serie
                        ), list = list as ArrayList<Perna>, adapter = this
                    ).execute()
                }
            }

            dialog.dismiss()
        }

        dialog.setNegativeButton(
            ResourcesUtils.getString(
                context,
                R.string.button_cancelar
            )
        ) { dialog, _ ->
            dialog.dismiss()
        }

        var alert = dialog.create()
        alert.show()
    }
}


