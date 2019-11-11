package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import com.gymseries.adapter.BycipesAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Biceps

class ListarBicepsAsyncTasks(
    val context: Context,
    private val listBiceps: ArrayList<Biceps>,
    private val adapter: BycipesAdapter
) : AsyncTask<String, String, List<Biceps>>() {


    override fun onPostExecute(result: List<Biceps>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty()) {
                for (biceps: Biceps in result) {
                    listBiceps.add(biceps)
                }
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(context, "List Database empty", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "Result == NULL", Toast.LENGTH_SHORT).show()
        }
    }

    override fun doInBackground(vararg params: String?): List<Biceps> {

        var appData = AppData.getInstance(context)
        var dao = appData.bicepsDao()
        return dao.all()
    }
}