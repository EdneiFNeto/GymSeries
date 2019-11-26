package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.IMC
import com.gymseries.utils.ResourcesUtils
import java.util.ArrayList

class IMCAdapter(val context: Context?, private val imcs: ArrayList<IMC>) :
    RecyclerView.Adapter<IMCAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_card_imc,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return imcs.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.add(imcs[position])
        if (context != null) {
            holder.result.setTextColor(context.resources.getColor(R.color.colorWhite))
        }

        holder.peso.text = holder.peso.text.toString().replace(".", ",")

        when {
            holder.result.text == ResourcesUtils.getString(context, R.string.peso_baixo) -> {
                holder.result.setBackgroundResource(R.color.colorYellow)
                if (context != null) {
                    holder.imc.setTextColor(context.resources.getColor(R.color.colorYellow))
                }
            }
            holder.result.text == ResourcesUtils.getString(context, R.string.peso_normal) -> {
                holder.result.setBackgroundResource(R.color.colorGreen)
                if (context != null) {
                    holder.imc.setTextColor(context.resources.getColor(R.color.colorGreen))
                }
            }
            holder.result.text == ResourcesUtils.getString(context, R.string.sobre_peso) -> {
                holder.result.setBackgroundResource(R.color.colorRedI)
                if (context != null) {
                    holder.imc.setTextColor(context.resources.getColor(R.color.colorRedI))
                }
            }
            holder.result.text == ResourcesUtils.getString(context, R.string.sobre_peso_g1) -> {
                holder.result.setBackgroundResource(R.color.colorRedI)
                if (context != null) {
                    holder.imc.setTextColor(context.resources.getColor(R.color.colorRedI))
                }
            }
            holder.result.text == ResourcesUtils.getString(context, R.string.sobre_peso_g2) -> {
                holder.result.setBackgroundResource(R.color.colorRedI)
                if (context != null) {
                    holder.imc.setTextColor(context.resources.getColor(R.color.colorRedI))
                }
            }
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView = itemView.findViewById<ImageView>(R.id.imageView_emoji)
        val peso = itemView.findViewById<TextView>(R.id.text_view_peso_imc)
        val data = itemView.findViewById<TextView>(R.id.text_view_data)
        val imc = itemView.findViewById<TextView>(R.id.text_imc)
        val result = itemView.findViewById<Button>(R.id.button_result_card_imc)

        fun add(i: IMC) {
            peso.text = if(i.peso > 0) "Peso: ${i.peso}Kg" else "Peso 0Kg"
            data.text = if(i.data.isNotEmpty()) "${i.data}" else "Não existe data"
            result.text = if(i.resultado.isNotEmpty()) i.resultado else "Não existe resultado"
            imc.text = if(i.imc.isNotEmpty()) "IMC: ${i.imc}" else "IMC: 0"
        }
    }

}
