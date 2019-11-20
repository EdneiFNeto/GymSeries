package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.Ombro
import com.gymseries.model.Perna
import com.gymseries.utils.ResourcesUtils
import java.util.ArrayList

class InsertOmBroAsynnc(val context: Context, private val ombros: ArrayList<Ombro>):
    AsyncTask<String, String, List<Ombro>>() {

    override fun onPostExecute(result: List<Ombro>?) {
        super.onPostExecute(result)
        //insert  Perna
        var pernas = arrayListOf<Perna>(
            Perna(
                id = 1,
                descr = ResourcesUtils.getString(context, R.string.agaichamento_livre),
                repeticao = "",
                peso = "",
                status = false
            ),Perna(
                id = 2,
                descr = ResourcesUtils.getString(context, R.string.extensora),
                repeticao = "",
                peso = "",
                status = false
            ),Perna(
                id = 3,
                descr = ResourcesUtils.getString(context, R.string.adutora),
                repeticao = "",
                peso = "",
                status = false
            ),Perna(
                id = 4,
                descr = ResourcesUtils.getString(context, R.string.agaichamento_smith),
                repeticao = "",
                peso = "",
                status = false
            )
        )

        InserPernaAsyncTasks(context, pernas).execute()
    }
    override fun doInBackground(vararg params: String?): List<Ombro> {
        var appData = AppData.getInstance(context)
        var dao = appData.ombroRoom()

        //if is database is empty
        //insert data db
        if(dao.all().isEmpty()){
            for(o in ombros)
                dao.insert(o)
        }
        return dao.all()
    }

}
