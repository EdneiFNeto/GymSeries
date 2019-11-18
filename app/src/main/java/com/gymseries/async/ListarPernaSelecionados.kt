package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.PernaAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Perna

class ListarPernaSelecionados(val context: Context,
                              private val adapter: PernaAdapter,
                              private val pernas: ArrayList<Perna>):
    AsyncTask<String, String, List<Perna>>() {

    override fun onPostExecute(result: List<Perna>?) {
        super.onPostExecute(result)
        if(GenericsUtil<Perna>().results(result, pernas)){
            adapter.notifyDataSetChanged()
        }
    }

    override fun doInBackground(vararg params: String?): List<Perna> {
        var data = AppData.getInstance(context)
        return data.pernaDao().allStates(false)
    }

}
