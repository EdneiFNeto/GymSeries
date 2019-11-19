package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.MyHolderGeneric
import org.w3c.dom.Text

class GenericAdapter<T>(val context: Context, private val list: List<T>) :
    RecyclerView.Adapter<MyHolderGeneric<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolderGeneric<T> {
        return MyHolderGeneric(
            LayoutInflater.from(context).inflate(
                R.layout.activity_biceps_triceps,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolderGeneric<T>, position: Int) {
        val t = list[position]
        holder.add(t)
    }
}