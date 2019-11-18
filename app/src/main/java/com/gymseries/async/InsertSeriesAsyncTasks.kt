package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.widget.BaseAdapter
import com.gymseries.adapter.SerieAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Serie

class InsertSeriesAsyncTasks(val context: Context, val adapter: BaseAdapter, val series: ArrayList<Serie>):
    AsyncTask<String, String, List<Serie>>() {

    override fun onPostExecute(result: List<Serie>?) {
        super.onPostExecute(result)
        if(result!=null){
            if(result.isNotEmpty()){
                for(s:Serie in result){
                    series.add(s)
                }
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun doInBackground(vararg p0: String?): List<Serie> {
        var appData = AppData.getInstance(context)
        var dao = appData.seriesDao()
        return dao.all()
    }

}
