package com.gymseries.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Serie
import com.gymseries.utils.LayoutUtils
import java.util.ArrayList

class SeriesAdapter(val context: Context?,
                    private val series: ArrayList<Serie>) :
    RecyclerView.Adapter<SeriesAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutUtils.inflateLayout(context, parent, R.layout.layout_serie))
    }

    override fun getItemCount(): Int {
        return series.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.add(series[position])
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.findViewById<TextView>(R.id.text_title_treino)
        private val numRepeticao = itemView.findViewById<TextView>(R.id.text_num_repeticao)
        private val textPeso = itemView.findViewById<TextView>(R.id.text_kg)
        private val textSerie = itemView.findViewById<TextView>(R.id.text_sigla_serie)

        fun add(serie:Serie){

            title.text = "${serie.id} - ${serie.descr} - ${serie.status}"
            numRepeticao.text = "${serie.repeticoes} Rept."
            textPeso.text = "${serie.peso} Kg."
            textSerie.text = serie.serie

        }
    }

}
