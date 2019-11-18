package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Triceps

class TricepsSelecionadoAdapter(val context: Context, val triceps: ArrayList<Triceps>):

    RecyclerView.Adapter<TricepsSelecionadoAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.activity_serie_adapter, parent, false))
    }

    override fun getItemCount(): Int {
        return triceps.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.add(triceps[position])
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun add(triceps: Triceps){
        }
    }

}
