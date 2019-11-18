package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.utils.AlertDialogUtis

abstract class BaseAdapter<T>(
    val context: Context,
    private val list: List<T>
):RecyclerView.Adapter<BaseAdapter.MyHolder<T>>() {

    override fun onBindViewHolder(holder: MyHolder<T>, position: Int) {
        holder.add(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder<T> {
        return MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_treino,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private  var title =  itemView.findViewById<TextView>(R.id.text_title_treino)
        private  var repeticao =  itemView.findViewById<TextView>(R.id.text_num_repeticao)
        private  var peso =  itemView.findViewById<TextView>(R.id.text_kg)

        fun add(t: T) {
            title.text = t.toString()
            repeticao.text=t.toString()
            peso.text=t.toString()
        }
    }
}