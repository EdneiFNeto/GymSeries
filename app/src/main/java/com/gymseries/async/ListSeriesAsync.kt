package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.adapter.SeriesAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Serie
import com.gymseries.utils.LoggerUtil
import java.util.ArrayList

class ListSeriesAsync(
    val context: Context?,
    private val series: ArrayList<Serie>,
    private val adapter: SeriesAdapter
) :
    AsyncTask<String, String, List<Serie>>() {


    private val TAG = "ListSeriesLog"

    override fun onPostExecute(result: List<Serie>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty()) {
                for (r in result) {
                    series.add(r)
                }
                adapter.notifyDataSetChanged()
            } else {
                LoggerUtil(TAG).error("result ${result?.size}")
            }
        } else {
            LoggerUtil(TAG).error("result ${result?.size}")
        }
    }

    override fun doInBackground(vararg params: String?): List<Serie>? {
        var appData = AppData.getInstance(context)
        val query = "SELECT * FROM Serie ORDER BY serie ASC"
        var room = appData?.serieRoom()
        return room?.all(SimpleSQLiteQuery(query))
    }

}
