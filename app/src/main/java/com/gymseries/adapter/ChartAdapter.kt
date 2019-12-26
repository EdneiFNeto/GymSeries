package com.gymseries.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.gymseries.R
import com.gymseries.model.Charts
import com.gymseries.utils.ResourcesUtils
import java.util.ArrayList
import com.anychart.enums.HoverMode
import com.anychart.enums.TooltipPositionMode
import com.anychart.enums.Anchor
import com.anychart.enums.Position


class ChartAdapter(val context: Context?, val charts: ArrayList<Charts>) :
    RecyclerView.Adapter<ChartAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.layout_chart_medida,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return charts.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.add(charts[position], context)
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        val anyChartView = itemView.findViewById<AnyChartView>(R.title.chart)
        fun add(charts: Charts, context: Context?) {
//            var cartesian: Cartesian = AnyChart.column()
//            var data: ArrayList<DataEntry> = arrayListOf()

//            data.add(
//                ValueDataEntry(
//                    ResourcesUtils.getString(context, R.string.peito),
//                    charts.peito
//                )
//            )
//            data.add(
//                ValueDataEntry(
//                    ResourcesUtils.getString(context, R.string.braco),
//                    charts.braco
//                )
//            )
//            data.add(
//                ValueDataEntry(
//                    ResourcesUtils.getString(context, R.string.title_cintura),
//                    charts.cintura
//                )
//            )
//            data.add(
//                ValueDataEntry(
//                    ResourcesUtils.getString(context, R.string.title_quadril),
//                    charts.quadril
//                )
//            )
//            data.add(
//                ValueDataEntry(
//                    ResourcesUtils.getString(context, R.string.title_coxa),
//                    charts.coxa
//                )
//            )
//            data.add(
//                ValueDataEntry(
//                    ResourcesUtils.getString(context, R.string.title_panturilha),
//                    charts.panturrilha
//                )
//            )

//            var column = cartesian.column(data)

//            column.tooltip()
//                .titleFormat("{%X}")
//                .position(Position.CENTER_BOTTOM)
//                .anchor(Anchor.CENTER_BOTTOM)
//                .offsetX(0.0)
//                .offsetY(5.0)
//                .format("\${%Value}{groupsSeparator: }")
//            cartesian.animation(true)
//            cartesian.descr("Top 10 Cosmetic Products by Revenue")
//            cartesian.yScale().minimum(0.0)
//            cartesian.yAxis(0).labels().format("\${%Value}{groupsSeparator: }")
//            cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
//            cartesian.interactivity().hoverMode(HoverMode.BY_X)
//            cartesian.xAxis(0).descr("Product")
//            cartesian.yAxis(0).descr("Revenue")
//            anyChartView.setChart(cartesian)
        }
    }

}
