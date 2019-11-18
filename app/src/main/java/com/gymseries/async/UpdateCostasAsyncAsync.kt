package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.CostasAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Costa
import com.gymseries.model.Ombro

class UpdateCostasAsyncAsync(
    val context: Context,
    private val costa: Costa,
    private val adapter: CostasAdapter,
    private val costas: ArrayList<Costa>
): AsyncTask<String, String, List<Costa>>() {



    override fun onPostExecute(result: List<Costa>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Costa>().results(result, costas))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg params: String?): List<Costa> {
        var data = AppData.getInstance(context)
        var dao = data.costasDao()
        dao.update(costa)
        return dao.all()
    }

}
