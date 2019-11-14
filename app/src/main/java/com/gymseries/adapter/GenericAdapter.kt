package com.gymseries.adapter

import android.content.Context
import android.os.Binder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class GenericAdapter<T>(private var itens: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItems(itens: List<T>) {
        this.itens = itens
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return getViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false)
            , viewType
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(itens[position])
    }

    override fun getItemCount(): Int {
        return this.itens.size

    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position, this.itens[position])
    }

    protected  abstract fun getLayoutId(position: Int, t: T): Int

    abstract fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder

    internal interface Binder<T> {
        fun bind(data: T)
    }
}