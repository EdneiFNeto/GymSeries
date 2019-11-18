package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import com.gymseries.adapter.TricepsAdapter
import com.gymseries.database.AppData
import com.gymseries.model.Triceps

class UpdateTricepsAsync(
    val context: Context,
    val triceps: Triceps,
    val adapter: TricepsAdapter,
    val listTrices: ArrayList<Triceps>
) :
    AsyncTask<String, String, List<Triceps>>() {

    private var TAG: String = "UpdateLog"

    override fun onPostExecute(result: List<Triceps>) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty()) {
                listTrices.clear()
                for (t in result) {
                    listTrices.add(t)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun doInBackground(vararg p0: String?): List<Triceps> {

        var data = AppData.getInstance(context)
        var dao = data.tricepsDao()
        var update = dao.update(triceps)
        return dao.all()
    }

}
