package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Biceps
import com.gymseries.utils.AlertDialogUtis

class BycipesAdapter(val context: Context, private val biceps: Array<Biceps>) :
    RecyclerView.Adapter<BycipesAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.activity_treino, parent, false))
    }

    override fun getItemCount(): Int {
        return biceps.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        var biceps:Biceps = biceps[position]
        holder.add(biceps)

        holder.itemView.setOnClickListener{
            AlertDialogUtis.alertDailogAddPesoNumRepeticao(context, holder, biceps)
        }
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val text_title_treino = itemView.findViewById<TextView>(R.id.text_title_treino)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView_treino)
        val text_kg = itemView.findViewById<TextView>(R.id.text_kg)
        val text_num_repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)

        fun add(biceps: Biceps){
            text_title_treino.text = biceps.descr
        }
    }
}
