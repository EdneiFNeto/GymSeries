package com.gymseries.async

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.Costa
import com.gymseries.model.Ombro
import com.gymseries.model.Perna
import com.gymseries.ui.MainActivity
import com.gymseries.utils.ResourcesUtils
import java.util.ArrayList

class InserPernaAsyncTasks(val context: Context, private val pernas: ArrayList<Perna>):
    AsyncTask<String, String, List<Perna>>() {

    override fun onPostExecute(result: List<Perna>?) {
        super.onPostExecute(result)

        var costas = arrayListOf<Costa>(
            Costa(
                id = 1,
                descr = ResourcesUtils.getString(context, R.string.barra_fixa),
                status = false,
                peso = "",
                repeticao = ""
            ), Costa(
                id = 2,
                descr = ResourcesUtils.getString(context, R.string.remada_curvada),
                status = false,
                peso = "",
                repeticao = ""
            ), Costa(
                id = 3,
                descr = ResourcesUtils.getString(context, R.string.barra_fixa_pegada_larg),
                status = false,
                peso = "",
                repeticao = ""
            ), Costa(
                id = 4,
                descr = ResourcesUtils.getString(context, R.string.remada_uni_halter),
                status = false,
                peso = "",
                repeticao = ""
            ), Costa(
                id = 5,
                descr = ResourcesUtils.getString(context, R.string.pulover_halter),
                status = false,
                peso = "",
                repeticao = ""
            ), Costa(
                id = 6,
                descr = ResourcesUtils.getString(context, R.string.remada_sentada),
                status = false,
                peso = "",
                repeticao = ""
            )
        )
        InserCostasAsync(context, costas).execute()
    }

    override fun doInBackground(vararg params: String?): List<Perna> {

        var appData = AppData.getInstance(context)
        var dao = appData.pernaDao()
        if(dao.all().isEmpty()){
            for (p in pernas){
                dao.insert(p)
            }
        }
        return dao.all()
    }

}
