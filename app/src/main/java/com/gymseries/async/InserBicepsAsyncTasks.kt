package com.gymseries.async

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import com.gymseries.database.AppData
import com.gymseries.model.Biceps
import com.gymseries.ui.BicepsActivity

class InserBicepsAsyncTasks(
    val context: Context,
    val biceps: Array<Biceps>
) : AsyncTask<String, String, List<Biceps>>() {

    private var TAG: String? = "InserBicepsAsyncTasksLog"

    override fun onPostExecute(result: List<Biceps>?) {
        super.onPostExecute(result)

        if (result != null) {
            if (result.isNotEmpty()) {
                for (biceps: Biceps in result) {
                    Log.e(TAG, "Reult ${biceps.descr}")
                }
                context.startActivity(Intent(context, BicepsActivity::class.java))
            } else {
                Log.e(TAG, "Reult ${result.size}")
            }
        } else {
            Log.e(TAG, "Reult NULL")
        }

    }

    override fun doInBackground(vararg params: String?): List<Biceps> {

        var database = AppData.getInstance(context)
        var dao = database.bicepsDao()
        dao.delete()


        for (bicep in biceps) {
            dao.insert(bicep)
        }

        return dao.all()
    }
}