package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R

class SerieAdapter<T>(val context: Context, private val series: ArrayList<T>) :
    RecyclerView.Adapter<SerieAdapter.MyHolder<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder<T> {
        return MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_serie_adapter,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return series.size
    }

    override fun onBindViewHolder(holder: MyHolder<T>, position: Int) {
        holder.add(series[position])
    }

    class MyHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun add(t: T) {
        }
    }
}

