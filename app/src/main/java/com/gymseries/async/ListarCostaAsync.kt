package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.CostasAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Costa
import java.util.*

class ListarCostaAsync(
    val context: Context,
    private  val costas: ArrayList<Costa>,
    private val adapter: CostasAdapter) : AsyncTask<String, String, List<Costa>>() {


    override fun onPostExecute(result: List<Costa>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Costa>().results(result, costas))
            adapter.notifyDataSetChanged()
    }


    override fun doInBackground(vararg params: String?): List<Costa> {

        var data = AppData.getInstance(context)
        var dao = data.costaDao()
        return dao.all()
    }

}
