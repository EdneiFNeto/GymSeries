package com.gymseries.async

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import com.gymseries.ui.MainActivity
import com.gymseries.database.AppData
import com.gymseries.model.Triceps

class InsertTricepsAsynctasks(val context: Context, var triceps: ArrayList<Triceps>) :
    AsyncTask<String, String, List<Triceps>>() {

    private var TAG: String = "InsertTricepsAsynctasks"

    override fun onPostExecute(result: List<Triceps>?) {
        super.onPostExecute(result)
        if (result != null) {
            if (result.isNotEmpty())
                context.startActivity(Intent(context, MainActivity::class.java));
        }
    }

    override fun doInBackground(vararg params: String?): List<Triceps> {

        var data = AppData.getInstance(context)
        var dao = data.tricepsDao()
        for (t in triceps)
            dao.insert(t)


        return dao.all()
    }

}
