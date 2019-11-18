package com.gymseries.adapter

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.database.AppData
import com.gymseries.model.Costa
import com.gymseries.model.Peito
import com.gymseries.model.Perna
import com.gymseries.model.Triceps
import java.util.ArrayList

class ListarPeitoSelecionados(
    val context: Context,
    private val adapter: PeitoAdapter,
    private val peitos:  ArrayList<Peito>
): AsyncTask<String, String, List<Peito>>() {

    override fun onPostExecute(result: List<Peito>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Peito>().results(result, peitos))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg params: String?): List<Peito> {
        var data = AppData.getInstance(context)
        var dao = data.peitoDao()
        return dao.allStates(true)
    }
}
