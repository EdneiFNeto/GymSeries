package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.GenericsUtil
import com.gymseries.adapter.ChartAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Charts
import java.util.ArrayList

class ListarMedidas(
    val context: Context?,
    private val charts: ArrayList<Charts>,
    val adapter: ChartAdapter
) :
    AsyncTask<String, String, List<Charts>>() {

    private val TAG = "ListarMedidasLog"

    override fun onPostExecute(result: List<Charts>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty()) {
                charts.clear()
                for (t in result) {
                    charts.add(t)
                }
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun doInBackground(vararg params: String?): List<Charts>? {

        var data = AppData.getInstance(context)
        return data?.chartsRoom()?.all(SimpleSQLiteQuery("SELECT * FROM Charts ORDER BY id DESC"))
    }

}
