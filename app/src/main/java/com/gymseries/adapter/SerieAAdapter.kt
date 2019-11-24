package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Triceps
import java.util.ArrayList

class SerieAAdapter(val context: Context?, private val series: ArrayList<Triceps>) :
    RecyclerView.Adapter<SerieAAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.layout_serie, parent, false))
    }

    override fun getItemCount(): Int {
        return series.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.add(series[position])
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)
        private var treino = itemView.findViewById<TextView>(R.id.text_num_repeticao)

        fun add(t: Triceps){
            repeticao.text = t.repeticoes
            treino.text = t.descr
        }
    }

}
