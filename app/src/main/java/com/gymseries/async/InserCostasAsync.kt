package com.gymseries.async

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import com.gymseries.database.AppData
import com.gymseries.model.Costa
import com.gymseries.ui.MainActivity
import java.util.ArrayList

class InserCostasAsync(
    val context: Context,
    private val costas: ArrayList<Costa>
) : AsyncTask<String, String, List<Costa>>() {


    override fun onPostExecute(result: List<Costa>?) {
        super.onPostExecute(result)
        context.startActivity(Intent(context, MainActivity::class.java))
    }

    override fun doInBackground(vararg params: String?): List<Costa> {

        var data = AppData.getInstance(context)
        var dao = data.costasDao()

        //if my list is empty
        //insert boceps
        if (dao.all().isEmpty()) {
            for (c in costas) {
                dao.insert(c)
            }
        }
        return dao.all()
    }

}
