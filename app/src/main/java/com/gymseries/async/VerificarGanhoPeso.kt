package com.gymseries.async

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import androidx.sqlite.db.SimpleSQLiteQuery
import com.gymseries.database.AppData
import com.gymseries.model.IMC

class VerificarGanhoPeso(val context: Context?, val ganhoPeso: TextView?):
    AsyncTask<String, String, List<IMC>>() {
    override fun doInBackground(vararg params: String?): List<IMC>? {
        var instance = AppData.getInstance(context)
        var room = instance?.imcRoom()
        return room?.all(SimpleSQLiteQuery("SELECT * FROM IMC"))
    }

}
