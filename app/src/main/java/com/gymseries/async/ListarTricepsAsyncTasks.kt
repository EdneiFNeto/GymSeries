package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Triceps

class ListarTricepsAsyncTasks(val context: Context,
                              val triceps: ArrayList<Triceps>,
                              val adapter: TricepsAdapter) : AsyncTask<String, String, List<Triceps>>(){

    private var TAG: String="ListarTricepsAsyncTasksLog"

    override fun onPostExecute(result: List<Triceps>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Triceps>().results(result, triceps))
            adapter.notifyDataSetChanged()
    }
    override fun doInBackground(vararg params: String?): List<Triceps> {
        var data = AppData.getInstance(context)
        var tricepsDao = data.tricepsDao()
        return tricepsDao.all()
    }

}
