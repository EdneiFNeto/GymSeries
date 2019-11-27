package com.gymseries.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.gymseries.R
import com.gymseries.model.Charts
import com.gymseries.utils.ResourcesUtils
import java.util.*


class ChartAdapter(val context: Context?, val charts: ArrayList<Charts>) :
    RecyclerView.Adapter<ChartAdapter.MyHolder>() {

    private val TAG = "ChartAdapterLog"

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

        lateinit var barEntries: ArrayList<BarEntry>
        private val TAG = "MyholderCharsLog"
        var bar = itemView.findViewById<BarChart>(R.id.chart_bar)
        var title_chart = itemView.findViewById<TextView>(R.id.text_title_chart)

        fun add(charts: Charts, context: Context?) {

            title_chart.text = "${ResourcesUtils.getString(context, R.string.title_chart)} - ${charts.data}"
            initBar()

            barEntries = arrayListOf(
                BarEntry(1f, charts.braco.toFloat()),
                BarEntry(2f, charts.peito.toFloat()),
                BarEntry(3f, charts.coxa.toFloat()),
                BarEntry(4f, charts.cintura.toFloat()),
                BarEntry(5f, charts.quadril.toFloat()),
                BarEntry(6f, charts.panturrilha.toFloat())
            )

            getxAxis(bar, context)
            var description = bar.description
            description.isEnabled = false

            var barDataSet = BarDataSet(barEntries, "Medidas")
            barDataSet.colors = arrayListOf(
                context?.resources?.getColor(R.color.colorRed),
                context?.resources?.getColor(R.color.colorOrange),
                context?.resources?.getColor(R.color.primaryDarkColor),
                context?.resources?.getColor(R.color.colorGreen),
                context?.resources?.getColor(R.color.colorblue),
                context?.resources?.getColor(R.color.colorYellow)
            )

            var data = BarData(barDataSet)

            bar.data = data
            data.barWidth = 0.9f

        }

        private fun getxAxis(
            barChart: BarChart,
            context: Context?
        ): XAxis {

            var xAxis = barChart.xAxis
            xAxis.valueFormatter = MyAxiFormater(context)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.textSize = 10f
            xAxis.textColor = Color.BLACK
            xAxis.setDrawAxisLine(false)
            xAxis.setDrawGridLines(false)

            return xAxis
        }

        private fun initBar() {
            bar.setScaleEnabled(false)
            bar.setDrawValueAboveBar(false)
            bar.setPinchZoom(false)
        }
    }

}

class MyAxiFormater(context: Context?) : ValueFormatter() {

    private val descr = arrayOf(
        ResourcesUtils.getString(context, R.string.title_braco),
        ResourcesUtils.getString(context, R.string.title_braco),
        ResourcesUtils.getString(context, R.string.title_peito),
        ResourcesUtils.getString(context, R.string.title_coxa),
        ResourcesUtils.getString(context, R.string.title_cintura),
        ResourcesUtils.getString(context, R.string.title_quadril),
        ResourcesUtils.getString(context, R.string.title_panturilha)
    )

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return descr.getOrNull(value.toInt()) ?: value.toString()
    }
}
