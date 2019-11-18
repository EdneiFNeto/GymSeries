package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.GenericsUtil
import com.gymseries.adapter.OmbroAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Ombro
import java.util.ArrayList

class ListarOmbrosAsync(val context: Context,
                        private val ombros: ArrayList<Ombro>,
                        private val adapter: OmbroAdapter) :
    AsyncTask<String, String, List<Ombro>>() {

    override fun onPostExecute(result: List<Ombro>?) {
        super.onPostExecute(result)
        if (GenericsUtil<Ombro>().results(result, ombros))
            adapter.notifyDataSetChanged()
    }

    override fun doInBackground(vararg params: String?): List<Ombro> {
        var data = AppData.getInstance(context)
        return data.ombroDao().all()
    }

}
