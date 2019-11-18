package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.PeitoAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Peito
import java.util.ArrayList

class ListarPeitoAsync(
    val context: Context,
    private val peitos: ArrayList<Peito>,
    private val adapter: PeitoAdapter
) :
    AsyncTask<String, String, List<Peito>>() {

    private val TAG = "ListarPeitoAsyncLog"

    override fun onPostExecute(result: List<Peito>) {
        super.onPostExecute(result)
        if (GenericsUtil<Peito>().results(result, peitos))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg params: String?): List<Peito> {
        var appData = AppData.getInstance(context)
        var dao = appData.peitoDao()
        return dao.all()
    }


}
