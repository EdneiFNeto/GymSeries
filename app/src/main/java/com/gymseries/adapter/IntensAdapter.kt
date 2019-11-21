package com.gymseries.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gymseries.R
import com.gymseries.model.Itens
import com.gymseries.ui.*

class IntensAdapter(private val context: Context, private  val list: Array<Itens>):
    RecyclerView.Adapter<IntensAdapter.MyHolder>() {

    private val TAG: String="IntensAdapterLog"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.layout_itens_corpo, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val itens:Itens = list[position]
        holder.add(itens)

        holder.itemView.setOnClickListener{

            when(position){
                0-> context.startActivity(Intent(context, BicepsActivity::class.java))
                1-> context.startActivity(Intent(context, Tricesctivity::class.java))
                2-> context.startActivity(Intent(context, PeitoActivity::class.java))
                3-> context.startActivity(Intent(context, OmbroActivity::class.java))
                4-> context.startActivity(Intent(context, CostasActivity::class.java))
                5-> context.startActivity(Intent(context, PernaActivity::class.java))
                6-> context.startActivity(Intent(context, IMCActivity::class.java))
//                7-> context.startActivity(Intent(context, SerieActivity::class.java))
                7-> context.startActivity(Intent(context, SerieATabLayoutctivity::class.java))
            }
        }
    }


    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var icon: ImageView? = itemView.findViewById(R.id.imageVew_icon);
        private var title: TextView? = itemView.findViewById(R.id.text_title);
        private var descr: TextView? = itemView.findViewById(R.id.text_descr);

        fun add(itens:Itens){
            icon?.setBackgroundResource(itens.icon)
            title?.text = itens.title
            descr?.text = itens.desc
        }
    }
}
