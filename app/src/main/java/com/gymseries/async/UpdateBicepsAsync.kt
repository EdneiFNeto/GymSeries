package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.GenericsUtil
import com.gymseries.adapter.BycipesAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Biceps

class UpdateBicepsAsync(
    val context: Context,
    private val bicep: Biceps,
    private val adapter: BycipesAdapter,
    private val biceps: ArrayList<Biceps>
) : AsyncTask<String, String, List<Biceps>>() {

    private var TAG: String = "UpdateBicepsAsyncLog"

    override fun onPostExecute(result: List<Biceps>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Biceps>().results(result, biceps))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg params: String?): List<Biceps> {
        var data = AppData.getInstance(context)
        var dao = data.bicepsRoom()
        dao.update(bicep)
        return dao.all(SimpleSQLiteQuery("SELECT * FROM Biceps"))
    }

}
