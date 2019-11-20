package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Triceps

class UpdateTricepsAsync(
    val context: Context,
    val tricep: Triceps,
    val adapter: TricepsAdapter,
    val triceps: ArrayList<Triceps>
) : AsyncTask<String, String, List<Triceps>>() {

    private var TAG: String = "UpdateLog"

    override fun onPostExecute(result: List<Triceps>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Triceps>().results(result, triceps))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg p0: String?): List<Triceps> {

        var data = AppData.getInstance(context)
        var dao = data.tricepsRoom()
        var update = dao.update(tricep)
        return dao.all()
    }

}
