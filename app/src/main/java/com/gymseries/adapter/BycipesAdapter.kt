package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Biceps

class BycipesAdapter(val context: Context, private val biceps: ArrayList<Biceps>) :
    RecyclerView.Adapter<BycipesAdapter.MyHolder>() {

    private var TAG: String="BycipesAdapterLog"

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
        return biceps.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        var bicep: Biceps = biceps[position]
        holder.add(bicep)

        if (bicep.status) {
            holder.itemView.setBackgroundResource(R.color.colorAccent)
        } else {
            holder.itemView.setBackgroundResource(android.R.color.transparent)
        }

        holder.itemView.setOnClickListener {
            dialog(bicep, biceps)
        }
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text_title_treino = itemView.findViewById<TextView>(R.id.text_title_treino)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView_treino)
        val text_kg = itemView.findViewById<TextView>(R.id.text_kg)
        val text_num_repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)

        fun add(biceps: Biceps) {
            text_title_treino.text = biceps.descr
            text_kg.text = "Peso: ${biceps.peso}"
            text_num_repeticao.text ="Repetição: ${biceps.repeticoes}"
        }
    }

    fun dialog(bicep: Biceps, biceps: ArrayList<Biceps>) {

        //exeibe dialog para opcao de treinos
        var builder = AlertDialog.Builder(context)
        builder.setIcon(R.mipmap.ic_descri_treino)
        val title = bicep.descr
        builder.setTitle(title)

        val view: View =
            LayoutInflater.from(context).inflate(R.layout.layout_select_peso_repeticao_treino, null)
        var edittext_kg = view.findViewById<EditText>(R.id.edttext_kg)
        var edittext_num_repeticao = view.findViewById<EditText>(R.id.edittext_repeticao)
        var button_salvar = view.findViewById<Button>(R.id.button_salvar_dialog_treino)
        var status = view.findViewById<Switch>(R.id.switch_is_enabled)

        edittext_kg.setText(bicep.peso)
        edittext_num_repeticao.setText(bicep.repeticoes)

        if (bicep.status)
            status.isChecked = true

        builder.setView(view)
        var dialog = builder.create()
        dialog.show()

        button_salvar.setOnClickListener {

            var b = Biceps(
                id = bicep.id,
                status = status.isChecked,
                repeticoes = edittext_num_repeticao.text.toString(),
                peso = edittext_kg.text.toString(),
                descr = bicep.descr
            )

            //UpdateBicepsAsync(context, b, this, biceps).execute()
            dialog.dismiss()
        }
    }
}
