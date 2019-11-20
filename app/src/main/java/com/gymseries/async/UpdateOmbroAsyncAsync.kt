package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.OmbroAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Ombro
import java.util.ArrayList

class UpdateOmbroAsyncAsync(
    val context: Context,
    private val ombro: Ombro,
    private val adapter: OmbroAdapter,
    private val ombros: ArrayList<Ombro>
) : AsyncTask<String, String, List<Ombro>>() {

    override fun onPostExecute(result: List<Ombro>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Ombro>().results(result, ombros))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg params: String?): List<Ombro> {
        var data = AppData.getInstance(context)
        var dao = data.ombroRoom()
        dao.update(ombro)
        return dao.all()
    }

}
