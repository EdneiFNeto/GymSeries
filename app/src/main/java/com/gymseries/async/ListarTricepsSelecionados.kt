package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.gymseries.GenericsUtil
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Peito
import com.gymseries.model.Triceps
import java.util.*

class ListarTricepsSelecionados(
    val context: Context,
    private val adapter: TricepsAdapter,
    private val triceps: ArrayList<Triceps>
) : AsyncTask<String, String, List<Triceps>>() {

    private var TAG: String= "ListarTricepsSelectLog"

    override fun onPostExecute(result: List<Triceps>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Triceps>().results(result, triceps))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg p0: String?): List<Triceps> {
        var data = AppData.getInstance(context)
        var dao = data.tricepsDao()
        return dao.allStates(true)
    }


}
