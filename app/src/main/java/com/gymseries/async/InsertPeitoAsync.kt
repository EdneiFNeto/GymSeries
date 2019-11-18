package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.Ombro
import com.gymseries.model.Peito
import com.gymseries.utils.ResourcesUtils
import java.util.ArrayList

class InsertPeitoAsync(val context: Context, private val peitos: ArrayList<Peito>) :
    AsyncTask<String, String, List<Peito>>() {

    private val TAG = "InsertPeitoLogs"

    override fun onPostExecute(result: List<Peito>?) {
        super.onPostExecute(result)

        var ombros = arrayListOf<Ombro>(
            Ombro(
                id = 1,
                descr = ResourcesUtils.getString(context, R.string.ombro_remada_alta),
                status = false,
                peso = "",
                repeticao = ""
            ), Ombro(
                id = 2,
                descr = ResourcesUtils.getString(context, R.string.ombro_remada_aparelho),
                status = false,
                peso = "",
                repeticao = ""
            ), Ombro(
                id = 3,
                descr = ResourcesUtils.getString(context, R.string.ombro_alternada),
                status = false,
                peso = "",
                repeticao = ""
            )
        )
        InsertOmBroAsynnc(context, ombros).execute()
    }

    override fun doInBackground(vararg params: String?): List<Peito> {

        var data = AppData.getInstance(context)
        var dao = data.peitoDao()

        if (dao.all().isEmpty()) {
            for (p in peitos)
                dao.insert(p)
        }

        return dao.all()
    }

}
