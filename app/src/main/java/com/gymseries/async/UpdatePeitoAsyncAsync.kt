package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.PeitoAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Biceps
import com.gymseries.model.Peito

class UpdatePeitoAsyncAsync(val context: Context,
                            private val peito: Peito,
                            private val adapter: PeitoAdapter,
                            private val peitos: ArrayList<Peito>):
    AsyncTask<String, String, List<Peito>>() {


    override fun onPostExecute(result: List<Peito>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Peito>().results(result, peitos))
            adapter.notifyDataSetChanged()
    }
    override fun doInBackground(vararg params: String?): List<Peito> {
        var data = AppData.getInstance(context)
        var dao = data.peitoDao()
        dao.update(peito)
        return dao.all()
    }

}
