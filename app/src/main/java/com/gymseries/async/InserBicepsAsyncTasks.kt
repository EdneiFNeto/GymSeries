package com.gymseries.async

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import com.gymseries.R
import com.gymseries.database.AppData
import com.gymseries.model.Biceps
import com.gymseries.model.Triceps
import com.gymseries.ui.BicepsActivity
import com.gymseries.utils.ResourcesUtils

class InserBicepsAsyncTasks(
    val context: Context,
    val biceps: Array<Biceps>
) : AsyncTask<String, String, List<Biceps>>() {

    private var TAG: String? = "InserBicepsAsyncTasksLog"

    override fun onPostExecute(result: List<Biceps>?) {
        super.onPostExecute(result)

        if (result != null) {
            if (result.isNotEmpty()) {

                var triceps = arrayListOf<Triceps>(

                    Triceps(id = 1, descr = ResourcesUtils.getString(context, R.string.triceps_no_banco), status = false, pepeticao = "0", peso = "0"),
                    Triceps(id = 2, descr = ResourcesUtils.getString(context, R.string.testa), status = false, pepeticao = "0", peso = "0"),
                    Triceps(id = 3, descr = ResourcesUtils.getString(context, R.string.supinado), status = false, pepeticao = "0", peso = "0"),
                    Triceps(id = 4, descr = ResourcesUtils.getString(context, R.string.tirceps_barra_alta), status = false, pepeticao = "0", peso = "0"),
                    Triceps(id = 5, descr = ResourcesUtils.getString(context, R.string.rosca_inversa), status = false, pepeticao = "0", peso = "0"),
                    Triceps(id = 6, descr = ResourcesUtils.getString(context, R.string.mergulho), status = false, pepeticao = "0", peso = "0"),
                    Triceps(id = 7, descr = ResourcesUtils.getString(context, R.string.tirceps_corda), status = false, pepeticao = "0", peso = "0")
                )

                InsertTricepsAsynctasks(context, triceps).execute()

            } else {
                Log.e(TAG, "Reult ${result.size}")
            }
        } else {
            Log.e(TAG, "Reult NULL")
        }

    }

    override fun doInBackground(vararg params: String?): List<Biceps> {

        var database = AppData.getInstance(context)
        var dao = database.bicepsRoom()
        for (bicep in biceps) {
            dao.insert(bicep)
        }

        return dao.all()
    }
}