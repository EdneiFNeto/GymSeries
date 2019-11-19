package com.gymseries.model

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R

class MyHolderGeneric<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var title = itemView.findViewById<TextView>(R.id.text_title_treino)
    private var repeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)
    private var peso = itemView.findViewById<TextView>(R.id.text_kg)

    fun add(t: T) {
        title.text = t.toString()
        repeticao.text = t.toString()
        peso.text = t.toString()
    }
}
