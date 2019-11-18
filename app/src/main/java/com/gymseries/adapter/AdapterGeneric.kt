package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R

class AdapterGeneric<T>(val context: Context, private val peitos: ArrayList<T>):
    RecyclerView.Adapter<AdapterGeneric.MyHolder<T>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder<T> {
        return MyHolder(
            LayoutInflater.from(context).inflate(R.layout.activity_serie_adapter, parent , false)
        )
    }

    override fun onBindViewHolder(holder: MyHolder<T>, position: Int) {
        holder.add(peitos[position])
    }


    override fun getItemCount(): Int {
        return peitos.size
    }


    class MyHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val descr = itemView.findViewById<TextView>(R.id.text_descr_serie_adapter)
        private val peso = itemView.findViewById<TextView>(R.id.text_peso_serie_adapter)
        private val repeticoes = itemView.findViewById<TextView>(R.id.text_repeticao_serie_adapter)

        fun add(t: T){

        }
    }

}
