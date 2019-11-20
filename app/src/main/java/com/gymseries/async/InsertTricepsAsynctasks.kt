package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.Peito
import com.gymseries.model.Triceps
import com.gymseries.utils.ResourcesUtils

class InsertTricepsAsynctasks(val context: Context, var triceps: ArrayList<Triceps>) :
    AsyncTask<String, String, List<Triceps>>() {

    private var TAG: String = "InsertTricepsAsynctasks"

    override fun onPostExecute(result: List<Triceps>?) {
        super.onPostExecute(result)
        var peitos = arrayListOf<Peito>(
            Peito(
                id = 1,
                descr = ResourcesUtils.getString(context, R.string.supino_reto),
                repeticao = "",
                peso = "",
                status = false
            ),Peito(
                id = 2,
                descr = ResourcesUtils.getString(context, R.string.supino_45),
                repeticao = "",
                peso = "",
                status = false
            ),Peito(
                id = 3,
                descr = ResourcesUtils.getString(context, R.string.voador),
                repeticao = "",
                peso = "",
                status = false
            ),Peito(
                id = 3,
                descr = ResourcesUtils.getString(context, R.string.crussifixo),
                repeticao = "",
                peso = "",
                status = false
            )
        )
        InsertPeitoAsync(context, peitos).execute()
    }

    override fun doInBackground(vararg params: String?): List<Triceps> {

        var data = AppData.getInstance(context)
        var dao = data.tricepsRoom()

        //if my lists is empty
        //insert data
        if (dao.all().isEmpty()) {
            for (t in triceps)
                dao.insert(t)
        }

        return dao.all()
    }

}
