package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Triceps
import com.gymseries.utils.AlertDialogUtis

class TricepsAdapter(val context: Context, private val triceps: Array<Triceps>) :
    RecyclerView.Adapter<TricepsAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.activity_treino, parent, false))
    }

    override fun getItemCount(): Int {
        return triceps.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var tricep: Triceps = triceps[position]
        holder.add(tricep)

        holder.itemView.setOnClickListener{
            AlertDialogUtis.alertDailogAddPesoNumRepeticao(context, holder, tricep)
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val title_item_treino = itemView.findViewById<TextView>(R.id.text_title_treino)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView_treino)
        val text_kg = itemView.findViewById<TextView>(R.id.text_kg)
        val text_num_repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)

        fun add(tricep:  Triceps){
            title_item_treino.text = tricep.descr
        }
    }

}
