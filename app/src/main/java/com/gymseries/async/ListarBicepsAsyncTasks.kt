package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.BycipesAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Biceps

class ListarBicepsAsyncTasks(
    val context: Context,
    private val biceps: ArrayList<Biceps>,
    private val adapter: BycipesAdapter
) : AsyncTask<String, String, List<Biceps>>() {

    override fun onPostExecute(result: List<Biceps>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Biceps>().results(result, biceps))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg params: String?): List<Biceps> {
        var appData = AppData.getInstance(context)
        var dao = appData.bicepsRoom()
        return dao.all()
    }
}